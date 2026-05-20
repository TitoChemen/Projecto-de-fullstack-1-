package cl.duoc.notificaciones_service.controller;

import cl.duoc.notificaciones_service.dto.NotificacionDTO;
import cl.duoc.notificaciones_service.model.Notificacion;
import cl.duoc.notificaciones_service.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {
    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(notificacionService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        NotificacionDTO notificacion = notificacionService.findById(id);
        if (notificacion == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(notificacion);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Notificacion notificacion){
        Notificacion notifNueva = notificacionService.save(notificacion);
        return new ResponseEntity<>(notifNueva, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        notificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Notificacion notificacion){
        Notificacion notifActualizada = notificacionService.update(id, notificacion);
        if (notifActualizada == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(notifActualizada);
    }
}
