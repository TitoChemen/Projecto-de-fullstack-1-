package cl.duoc.carrito_service.service;

import cl.duoc.carrito_service.dto.CarritoDTO;
import cl.duoc.carrito_service.dto.InventarioDTO;
import cl.duoc.carrito_service.dto.UsuarioDTO;
import cl.duoc.carrito_service.feign.InventarioFeign;
import cl.duoc.carrito_service.feign.UsuarioFeign;
import cl.duoc.carrito_service.mapper.CarritoMapper;
import cl.duoc.carrito_service.model.Carrito;
import cl.duoc.carrito_service.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private CarritoMapper carritoMapper;

    @Autowired
    private UsuarioFeign usuarioFeign;

    @Autowired
    private InventarioFeign inventarioFeign;



    public List<Carrito> findAll(){
        return carritoRepository.findAll();
    }

    public CarritoDTO findById(Long id){
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        return carritoMapper.toDTO(carrito);
    }

    // AQUÍ ESTÁ EL CAMBIO GROSO: Validación antes de guardar
    public Carrito save(Carrito c){
        // Pegamos al puerto 8080
        UsuarioDTO user = usuarioFeign.buscarPorID(c.getIdUsuario());

        // Pegamos al puerto 8083
        InventarioDTO inv = inventarioFeign.buscarPorId(c.getCodigoProducto());

        if (user == null) {
            throw new RuntimeException("Usuario no existe");
        }

        // Usamos 'inv.getStock()' porque es lo que viene de la API de Inventario
        if (inv == null || inv.getStock() < c.getCantidad()) {
            throw new RuntimeException("No hay stock suficiente en el pasillo " + inv.getPasillo());
        }

        return carritoRepository.save(c);
    }

    public void delete(Long id){
        carritoRepository.deleteById(id);
    }

    public Carrito update(Long id, Carrito carrito){
        Carrito carritoActualizar = carritoRepository.findById(id).orElse(null);
        if (carritoActualizar == null) return null;
        carritoActualizar.setCantidad(carrito.getCantidad());
        carritoActualizar.setCodigoProducto(carrito.getCodigoProducto());
        carritoActualizar.setPrecioUnitario(carrito.getPrecioUnitario());
        carritoActualizar.setIdUsuario(carrito.getIdUsuario());

        return carritoRepository.save(carritoActualizar);
    }


}
