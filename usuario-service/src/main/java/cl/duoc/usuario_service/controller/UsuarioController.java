package cl.duoc.usuario_service.controller;

import cl.duoc.usuario_service.dto.UsuarioDTO;
import cl.duoc.usuario_service.model.Usuario;
import cl.duoc.usuario_service.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // 1. LISTAR TODOS
    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    // 2. BUSCAR POR ID (Totalmente saneado con el DTO)
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        if (usuarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDTO);
    }

    // 3. REGISTRAR
    @PostMapping
    public ResponseEntity<?> registrar(@Valid @RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }

    // 4. BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 5. ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioService.update(id, usuario);
        if (usuarioActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioActualizado);
    }
}