package cl.duoc.pagos_service.feign;

import cl.duoc.pagos_service.dto.PagoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario-service",url = "http://localhost:8080/api/v1/usuario")
public interface UsuarioFeign {
    @GetMapping("/{id}")
    PagoDTO buscarPorID(@PathVariable("id")Long id);
}
