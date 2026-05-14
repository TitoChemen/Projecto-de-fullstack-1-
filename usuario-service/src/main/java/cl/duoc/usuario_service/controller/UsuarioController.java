package cl.duoc.usuario_service.controller;

import cl.duoc.usuario_service.model.Usuario;
import cl.duoc.usuario_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> borrar(@PathVariable Long id){
        usuarioService.delete(id);;
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioService.update(id, usuario);
        if (usuarioActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuarioActualizado);
    }


}
