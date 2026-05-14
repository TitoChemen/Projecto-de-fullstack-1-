package cl.duoc.carrito_service.mapper;

import cl.duoc.carrito_service.dto.CarritoDTO;
import cl.duoc.carrito_service.model.Carrito;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {
    public CarritoDTO toDTO(Carrito carrito){
        if (carrito == null) return null;
        CarritoDTO dto = new CarritoDTO();
        dto.setTotalbruto(carrito.getCantidad() + carrito.getPrecioUnitario());
        return dto;
    }
}
