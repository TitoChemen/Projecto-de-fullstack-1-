package cl.duoc.inventario_service.dto;

import lombok.Data;

@Data
public class InventarioDTO {
    private Long IdCarrito;

    //aqui juntaremos stock y pasillo
    private String infoUbicacion;

    //juntamos el estado con un codigo de alerta para la siguiente api
    private String estadoLogisitco;

    private int cantidadPedida;
}
