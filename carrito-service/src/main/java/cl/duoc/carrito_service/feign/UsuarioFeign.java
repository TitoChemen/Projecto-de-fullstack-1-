package cl.duoc.carrito_service.feign;

import cl.duoc.carrito_service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service",url = "http://localhost:8080")
public interface UsuarioFeign {
    @GetMapping("/api/v1/usuario/{id}")
    UsuarioDTO buscarPorID(@PathVariable("id")Long id);
}
