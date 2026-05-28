package cl.duoc.usuario_service.controller;

import cl.duoc.usuario_service.dto.UsuarioDTO;
import cl.duoc.usuario_service.model.Usuario;
import cl.duoc.usuario_service.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable("id") Long id){
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        if (usuarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable("id") Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioService.update(id, usuario);
        if (usuarioActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioActualizado);
    }
}