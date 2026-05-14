package cl.duoc.carrito_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoProducto;
    private int cantidad;
    private int precioUnitario;
    @Column(name = "usuario_id")
    private Long IdUsuario;
}
