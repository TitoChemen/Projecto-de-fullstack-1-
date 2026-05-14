package cl.duoc.descuentos_service.feing;

import cl.duoc.descuentos_service.dto.DescuentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "descuentos-service",url = "http://localhost:8080/api/v1/descuentos")
public interface DescuentoFeing {
    @GetMapping("/{id}")
    DescuentoDTO buscarPorId(@PathVariable("id")Long id);
}
