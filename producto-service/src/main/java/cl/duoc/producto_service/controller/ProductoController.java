package cl.duoc.producto_service.controller;

import cl.duoc.producto_service.dto.ProductoDTO;
import cl.duoc.producto_service.model.Producto;
import cl.duoc.producto_service.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    // ESTE ES EL QUE TE FALTABA PARA EL POSTMAN
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarTodos() {
        return ResponseEntity.ok(service.findAll());
    }

    // ESTE ES EL QUE YA TENÍAS PARA BUSCAR POR CÓDIGO
    @GetMapping("/{codigo}")
    public ResponseEntity<ProductoDTO> obtener(@PathVariable String codigo) {
        ProductoDTO p = service.buscarPorCodigo(codigo);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
        return new ResponseEntity<>(service.save(producto), HttpStatus.CREATED);
    }
}