package cl.duoc.pagos_service.feign;

import cl.duoc.pagos_service.dto.TransporteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transporte-service")
public interface TransporteFeign {

    @PostMapping("/api/v1/transporte")
    TransporteDTO crearOrdenDespacho(@RequestBody TransporteDTO transporte);
}