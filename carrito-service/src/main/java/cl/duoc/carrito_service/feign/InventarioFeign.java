package cl.duoc.carrito_service.feign;

import cl.duoc.carrito_service.dto.InventarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventario-service", url = "http://localhost:8083") // URL BASE limpia
public interface InventarioFeign {
    // El path NO es un String plano, es una ruta que Spring procesa
    @GetMapping("/api/v1/inventario/{id}")
    InventarioDTO buscarPorId(@PathVariable("id") String id); // El Long está bien aquí
}
