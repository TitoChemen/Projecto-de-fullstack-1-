package cl.duoc.descuentos_service.mapper;

import cl.duoc.descuentos_service.dto.DescuentoDTO;
import cl.duoc.descuentos_service.model.Descuento;
import org.springframework.stereotype.Component;

@Component
public class DescuentoMapper {

    public DescuentoDTO toDTO(Descuento descuento) {
        if (descuento == null) return null;

        DescuentoDTO dto = new DescuentoDTO();

        // Mapeamos los campos que sí existen en ambos lados
        dto.setMontoOriginal(descuento.getMontoOriginal());
        dto.setMontoDescuento(descuento.getMontoDescuento());

        // Lógica de la resta (sin casting raro, Long con Long nomás)
        long original = (descuento.getMontoOriginal() != null) ? descuento.getMontoOriginal() : 0L;
        long rebaja = (descuento.getMontoDescuento() != null) ? descuento.getMontoDescuento() : 0L;

        dto.setMontoFinal(original - rebaja);

        // Campos que están en el DTO pero NO en el modelo:
        // Los seteamos con valores genéricos para que no lleguen null
        dto.setCodigoPromocional("DESC-GENERICO");
        dto.setActivo(true);
        dto.setPorcentaje(0.0); // O calcula el porcentaje si quieres lucirte
        dto.setDescripcion("Descuento aplicado al carrito");

        return dto;
    }
}
