package cl.duoc.transporte_service.controller;

import cl.duoc.transporte_service.dto.TransporteDTO;
import cl.duoc.transporte_service.service.TransporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transportes")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(transporteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        TransporteDTO transporte = transporteService.findById(id);
        if (transporte == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transporte);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody TransporteDTO transporteDTO) {
        TransporteDTO transporteNuevo = transporteService.save(transporteDTO);
        return new ResponseEntity<>(transporteNuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody TransporteDTO transporteDTO) {
        TransporteDTO transporteActualizado = transporteService.update(id, transporteDTO);
        if (transporteActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transporteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        transporteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}