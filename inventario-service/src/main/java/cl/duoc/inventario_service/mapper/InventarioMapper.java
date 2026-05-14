package cl.duoc.inventario_service.mapper;

import cl.duoc.inventario_service.dto.InventarioDTO;
import cl.duoc.inventario_service.model.Inventario;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapper {

    public InventarioDTO toDTO(Inventario inventario, int cantidad) {
        if (inventario == null) return null;

        InventarioDTO dto = new InventarioDTO();

        dto.setId(inventario.getId());
        dto.setNombre("Producto Carrito: " + inventario.getIdCarrito());
        dto.setStock(inventario.getStockDisponible());
        dto.setCantidadPedida(cantidad); // <--- Aquí guardamos lo que llega al Service
        dto.setPasillo(inventario.getPasilloBodega());
        dto.setEstado(inventario.getEstadoStock());

        return dto;
    }
}