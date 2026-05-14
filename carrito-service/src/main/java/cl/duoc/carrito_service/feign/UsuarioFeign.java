package cl.duoc.carrito_service.feign;

import cl.duoc.carrito_service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service",url = "http://localhost:8080/api/v1/usuario")
public interface UsuarioFeign {
    @GetMapping("/{id}")
    UsuarioDTO buscarPorID(@PathVariable("id")Long id);
}
