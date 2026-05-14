package cl.duoc.inventario_service.dto;
import lombok.Data;

@Data
public class InventarioDTO {
    private Long id; // El ID del producto en inventario
    private String nombre;
    private int stock; // Cambia 'cantidadPedida' por lo que viene de la API
    private String pasillo;
    private String estado;
    private int cantidadPedida; // <--- Agregamos este para que el Service no llore
}