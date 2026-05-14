package cl.duoc.pagos_service.feign;

import cl.duoc.pagos_service.dto.DescuentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "descuentos-service", url = "http://localhost:8082")
public interface DescuentoFeign {
    @GetMapping("/api/v1/descuentos/{codigo}")
    DescuentoDTO validarDescuento(@PathVariable("codigo") String codigo);
}
