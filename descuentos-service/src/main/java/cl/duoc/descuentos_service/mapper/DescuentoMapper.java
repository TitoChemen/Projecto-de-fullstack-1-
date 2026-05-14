package cl.duoc.descuentos_service.mapper;

import cl.duoc.descuentos_service.dto.DescuentoDTO;
import cl.duoc.descuentos_service.model.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoMapper {
    public DescuentoDTO toDTO(Descuento descuento){
        if (descuento == null) return null;
        DescuentoDTO dto = new DescuentoDTO();
        // Hacemos el cálculo y lo transformamos a int (casting)
        // Se hace así para que el resultado de la resta quepa en el int del DTO
        long resta = descuento.getMontoOriginal() - descuento.getMontoDescuento();
        dto.setMontoFinal((int) resta);
        return dto;
    }
}
