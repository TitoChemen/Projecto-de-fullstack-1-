package cl.duoc.carrito_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("IdUsuario") // <--- ESTO OBLIGA A SPRING A LEERLO EN EL POST
    private Long IdUsuario;

}
