package cl.duoc.carrito_service.dto;

import lombok.Data;

@Data
public class CarritoDTO {
    private Long idCarrito;
    private String nombreCliente;
    private String correoCliente;
    private String codigoProducto;
    private int cantidad;
    private int precioUnitario;
    private int totalBruto;
}