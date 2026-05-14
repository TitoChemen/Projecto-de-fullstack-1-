package cl.duoc.inventario_service.mapper;

import cl.duoc.inventario_service.dto.InventarioDTO;
import cl.duoc.inventario_service.model.Inventario;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapper {

    public InventarioDTO toDTO(Inventario inventario, int cantidad) {
        InventarioDTO dto = new InventarioDTO();

        dto.setIdCarrito(inventario.getIdCarrito());
        dto.setCantidadPedida(cantidad);

        //Juntamos las variables
        dto.setInfoUbicacion(inventario.getEstadoStock() + "unidades disponibles en el " + inventario.getPasilloBodega());

        dto.setEstadoLogisitco("[" + inventario.getEstadoStock().toUpperCase() + "] - Procesado por Inventario");

        return dto;
    }
}