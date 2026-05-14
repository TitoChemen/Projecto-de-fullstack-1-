package cl.duoc.pagos_service.service;


import cl.duoc.pagos_service.dto.*;
import cl.duoc.pagos_service.feign.DescuentoFeign;
import cl.duoc.pagos_service.feign.FacturacionFeign;
import cl.duoc.pagos_service.feign.NotificacionFeign;
import cl.duoc.pagos_service.feign.TransporteFeign;
import cl.duoc.pagos_service.mapper.PagoMapper;
import cl.duoc.pagos_service.model.Pago;
import cl.duoc.pagos_service.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    @Autowired
    private PagoMapper pagoMapper;
    @Autowired
    private FacturacionFeign facturacionFeign;
    @Autowired
    private TransporteFeign transporteFeign;
    @Autowired
    private DescuentoFeign descuentoFeign;
    @Autowired
    private NotificacionFeign notificacionFeign;

    public List<Pago> findAll(){
        return pagoRepository.findAll();
    }

    public PagoDTO findById(Long id){
        Pago pago = pagoRepository.findById(id).orElse(null);
        return pagoMapper.toDTO(pago);
    }

    public Pago save(Pago p){
        // 1 calculamos el descuento primero
        String codigoPrueba = "DESC10";
        DescuentoDTO resultado = descuentoFeign.validarDescuento(codigoPrueba);
        // 2 si el descuento es valido y esta activo se aplica la resta
        if (resultado != null && resultado.isActivo()) {
            //hacemos las mates xd
            double porcentaje = resultado.getPorcentaje() / 100.0;
            // Usamos double para el cálculo y luego volvemos a Integer
            double descuento = p.getMontoPago().doubleValue() * porcentaje;
            int montoFinal = (int) (p.getMontoPago() - descuento);

            //actualizamos el monto antes de guardar en la bd
            p.setMontoPago(montoFinal);
        }

        Pago pagoGuardado = pagoRepository.save(p);

        FacturacionDTO factura = new FacturacionDTO();
        factura.setIdPago(pagoGuardado.getId());
        factura.setMonto(pagoGuardado.getMontoPago().doubleValue());
        factura.setDetalle("Pago realizado con" + pagoGuardado.getMetodoPago());
        facturacionFeign.crearFactura(factura);

        //transportes
        TransporteDTO despacho = new TransporteDTO();
        despacho.setIdPago(pagoGuardado.getId());
        despacho.setEstado("Preparando_Despacho");
        transporteFeign.crearOrdenDespacho(despacho);

        //notificaciones
        NotificacionDTO noti = new NotificacionDTO();

        //usemos el id del pago
        noti.setCodSeguimiento("SEG-" + pagoGuardado.getId());

        //le pasamos el estado q ya conocemos evidentemente xd
        noti.setEstadoEnv("Pago_Confirmado_Y_Procesado");

        //aqui podrias poner un mail para la prueba
        noti.setEmailNotificacion("cliente@correo.cl");
        notificacionFeign.enviarNotificacion(noti);
        return pagoGuardado;
    }

    public void delete(Long id){
        pagoRepository.deleteById(id);
    }

    public Pago update(Long id, Pago pago){
        Pago pagoActualizar = pagoRepository.findById(id).orElse(null);
        if (pagoActualizar == null) return null;
        pagoActualizar.setEstadoPago(pago.getEstadoPago()+ " " + pago.getMetodoPago());
        return pagoRepository.save(pagoActualizar);
    }
}
