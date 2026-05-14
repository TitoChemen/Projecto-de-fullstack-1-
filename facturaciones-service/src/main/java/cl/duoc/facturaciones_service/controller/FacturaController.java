package cl.duoc.facturaciones_service.controller;

import cl.duoc.facturaciones_service.dto.FacturacionDTO;
import cl.duoc.facturaciones_service.model.Facturacion;
import cl.duoc.facturaciones_service.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {
    @Autowired
    private FacturacionService facturacionService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(facturacionService.findAll());
    }

    // ARREGLO 1: Agregamos el /{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        FacturacionDTO facturacion = facturacionService.findById(id);
        if (facturacion == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(facturacion);
    }

    @PostMapping
    public ResponseEntity<?> registro(@RequestBody Facturacion f){
        Facturacion facturaNueva = facturacionService.save(f);
        return new ResponseEntity<>(facturaNueva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        facturacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ARREGLO 2: Cambiamos a PutMapping y agregamos /{id}
    @PutMapping("/{id}")
    // ARREGLO 3: Agregamos @PathVariable
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Facturacion facturacion){
        Facturacion facturaActualizada = facturacionService.update(id, facturacion);
        if (facturaActualizada == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(facturaActualizada);
    }
}