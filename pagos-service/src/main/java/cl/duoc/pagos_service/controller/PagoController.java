package cl.duoc.pagos_service.controller;

import cl.duoc.pagos_service.dto.PagoDTO;
import cl.duoc.pagos_service.model.Pago;
import cl.duoc.pagos_service.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(pagoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        PagoDTO pago = pagoService.findById(id);
        if (pago == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pago);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Pago pago){
        Pago pagoNuevo = pagoService.save(pago);
        return new ResponseEntity<>(pagoNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pago pago){
        Pago pagoActualizado = pagoService.update(id, pago);
        if (pagoActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pagoActualizado);
    }
}
