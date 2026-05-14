package cl.duoc.carrito_service.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private Long id;
    private String nombre;
    private int stock;
    private String pasillo;
    private String estado;
}