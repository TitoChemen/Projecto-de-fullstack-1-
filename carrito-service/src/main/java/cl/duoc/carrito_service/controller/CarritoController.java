package cl.duoc.carrito_service.controller;

import cl.duoc.carrito_service.dto.CarritoDTO;
import cl.duoc.carrito_service.model.Carrito;
import cl.duoc.carrito_service.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(carritoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        CarritoDTO carrito = carritoService.findById(id);
        if (carrito == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carrito);
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Carrito carrito){
        Carrito carritoNuevo = carritoService.save(carrito);
        return new ResponseEntity<>(carritoNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        carritoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Carrito carrito){
        Carrito carritoActualizado = carritoService.update(id, carrito);
        if (carritoActualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carritoActualizado);
    }

}
