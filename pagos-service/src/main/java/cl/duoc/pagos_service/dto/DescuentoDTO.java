package cl.duoc.pagos_service.dto;

import lombok.Data;
@Data
public class DescuentoDTO {
    private String codigoPromocional;
    private Double porcentaje;
    private boolean activo;
    private String descripcion;
    private Long montoOriginal;
    private Long montoDescuento;
    private Long montoFinal;
}

