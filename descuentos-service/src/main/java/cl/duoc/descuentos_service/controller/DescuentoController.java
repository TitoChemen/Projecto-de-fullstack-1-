package cl.duoc.descuentos_service.controller;

import cl.duoc.descuentos_service.dto.DescuentoDTO;
import cl.duoc.descuentos_service.model.Descuento;
import cl.duoc.descuentos_service.service.DescuentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/descuentos")
public class DescuentoController {
    @Autowired
    private DescuentoService descuentoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(descuentoService.findAll());
    }

    // ARREGLO AQUÍ: Agregamos el /{id} para que no choque con listar()
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        DescuentoDTO descuento = descuentoService.findById(id);
        if (descuento == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(descuento);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Descuento d){
        Descuento descuentoNuevo = descuentoService.save(d);
        return new ResponseEntity<>(descuentoNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        descuentoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ARREGLO AQUÍ TAMBIÉN: Te faltaba el /{id} en el PutMapping
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Descuento descuento){
        Descuento descuentoActualizado = descuentoService.update(id, descuento);
        if (descuentoActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(descuentoActualizado);
    }
}