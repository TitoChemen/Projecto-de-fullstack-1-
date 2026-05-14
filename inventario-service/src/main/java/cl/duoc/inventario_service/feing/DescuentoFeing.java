package cl.duoc.inventario_service.feing;

import cl.duoc.inventario_service.dto.InventarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "descuentos-service",url = "http://localhost:8080/api/v1/descuentos")
public interface DescuentoFeing {
    @GetMapping("/{id}")
    InventarioDTO buscarPorId(@PathVariable("id")Long id);
}
