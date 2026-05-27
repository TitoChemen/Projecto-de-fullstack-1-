package cl.duoc.carrito_service.feign;

import cl.duoc.carrito_service.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service")
public interface UsuarioFeign {
    // Ponemos la ruta completa desde el principio
    @GetMapping("/api/v1/usuario/{id}")
    UsuarioDTO buscarPorID(@PathVariable("id") Long id);
}