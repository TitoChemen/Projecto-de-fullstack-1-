package cl.duoc.inventario_service.controller;

import cl.duoc.inventario_service.dto.InventarioDTO;
import cl.duoc.inventario_service.model.Inventario;
import cl.duoc.inventario_service.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> listarTodo(){
        return ResponseEntity.ok(inventarioService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<InventarioDTO> buscarPorCodigo(
            @PathVariable String codigo,
            @RequestParam(value = "cantidad", required = false, defaultValue = "0") int cantidad) {

        InventarioDTO resultado = inventarioService.procesarInventario(codigo, cantidad);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @PostMapping // Para crear inventario nuevo
    public ResponseEntity<Inventario> crear(@Valid @RequestBody Inventario inventario){
        return new ResponseEntity<>(inventarioService.save(inventario), HttpStatus.CREATED);
    }
}