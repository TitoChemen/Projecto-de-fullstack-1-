package cl.duoc.facturaciones_service.mapper;

import cl.duoc.facturaciones_service.dto.FacturacionDTO;
import cl.duoc.facturaciones_service.model.Facturacion;
import org.springframework.stereotype.Component;

@Component
public class FacturacionMapper {
    public FacturacionDTO toDTO(Facturacion facturacion){
        if (facturacion == null) return null;
        FacturacionDTO dto = new FacturacionDTO();
        dto.setMontoFinal(facturacion.getTotal() + facturacion.getIva() + facturacion.getNeto());
        return dto;
    }
}
