package cl.duoc.pagos_service.service;


import cl.duoc.pagos_service.dto.PagoDTO;
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

    public List<Pago> findAll(){
        return pagoRepository.findAll();
    }

    public PagoDTO findById(Long id){
        Pago pago = pagoRepository.findById(id).orElse(null);
        return pagoMapper.toDTO(pago);
    }

    public Pago save(Pago p){
        return pagoRepository.save(p);
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
