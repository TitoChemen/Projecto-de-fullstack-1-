package cl.duoc.facturaciones_service.service;

import cl.duoc.facturaciones_service.dto.FacturacionDTO;
import cl.duoc.facturaciones_service.mapper.FacturacionMapper;
import cl.duoc.facturaciones_service.model.Facturacion;
import cl.duoc.facturaciones_service.repository.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturacionService {
    @Autowired
    private FacturacionRepository facturacionRepository;
    @Autowired
    private FacturacionMapper facturacionMapper;

    public List<Facturacion> findAll(){
        return facturacionRepository.findAll();
    }

    public FacturacionDTO findById(Long id){
        Facturacion facturacion = facturacionRepository.findById(id).orElse(null);
        return facturacionMapper.toDTO(facturacion);
    }

    public Facturacion save(Facturacion f){
        return facturacionRepository.save(f);
    }

    public void  delete(Long id){
        facturacionRepository.deleteById(id);
    }

    public Facturacion update(Long id, Facturacion facturacion){
        Facturacion totalPago = facturacionRepository.findById(id).orElse(null);
        if (totalPago == null) return null;
        totalPago.setNeto(facturacion.getNeto());
        totalPago.setTotal(facturacion.getTotal());

        return facturacionRepository.save(totalPago);
    }
}
