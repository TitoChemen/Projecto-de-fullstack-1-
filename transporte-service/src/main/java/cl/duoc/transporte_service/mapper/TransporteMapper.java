package cl.duoc.transporte_service.mapper;

import cl.duoc.transporte_service.dto.TransporteDTO;
import cl.duoc.transporte_service.model.Transporte;
import org.springframework.stereotype.Component;

@Component
public class TransporteMapper {
    public TransporteDTO toDTO(Transporte transporte){
        if (transporte == null) return null;
        TransporteDTO dto = new TransporteDTO();
        dto.setRuta(transporte.getDirecDestino());
        return dto;
    }

    public Transporte toEntity(TransporteDTO dto) {
        return null;
    }
}
