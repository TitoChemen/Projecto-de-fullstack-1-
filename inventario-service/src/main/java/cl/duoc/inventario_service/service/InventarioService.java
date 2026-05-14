package cl.duoc.inventario_service.service;

import cl.duoc.inventario_service.dto.InventarioDTO;
import cl.duoc.inventario_service.feing.DescuentoFeing;
import cl.duoc.inventario_service.mapper.InventarioMapper;
import cl.duoc.inventario_service.model.Inventario;
import cl.duoc.inventario_service.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private InventarioMapper inventarioMapper;

    //@Autowired
    //private DescuentoFeing descuentoFeing;

    public List<Inventario> findAll() {
        return inventarioRepository.findAll();
    }

    public InventarioDTO procesarInventario(Long id, int cantidadPerdida) {
        // 1. Buscamos el producto en nuestra bodega
        Inventario inventario = inventarioRepository.findById(id).orElse(null);

        if (inventario == null) return null;

        // 2 usamos el mMapper
        InventarioDTO dto = inventarioMapper.toDTO(inventario,cantidadPerdida);


        // 3 aca deberiamos de llamar tu api lulo
        //return descuentoFeignClient.aplicationDescuento(dto);

        return dto;
    }

    public Inventario save(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }
}
