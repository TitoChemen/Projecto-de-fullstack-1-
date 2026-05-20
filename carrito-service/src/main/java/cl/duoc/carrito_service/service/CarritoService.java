package cl.duoc.carrito_service.service;

import cl.duoc.carrito_service.dto.CarritoDTO;
import cl.duoc.carrito_service.dto.InventarioDTO;
import cl.duoc.carrito_service.dto.UsuarioDTO;
import cl.duoc.carrito_service.feign.InventarioFeign;
import cl.duoc.carrito_service.feign.UsuarioFeign;
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
    private UsuarioFeign usuarioFeign;

    @Autowired
    private InventarioFeign inventarioFeign;

    public List<Carrito> findAll(){
        return carritoRepository.findAll();
    }

    // 🔥 EL CAMBIO MAESTRO: Orquestación de datos para la vitrina 🔥
    public CarritoDTO findById(Long id){
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        if (carrito == null) return null;

        CarritoDTO dto = new CarritoDTO();
        dto.setIdCarrito(carrito.getId());
        dto.setCodigoProducto(carrito.getCodigoProducto());
        dto.setCantidad(carrito.getCantidad());
        dto.setPrecioUnitario(carrito.getPrecioUnitario());
        dto.setTotalBruto(carrito.getCantidad() * carrito.getPrecioUnitario());

        // Vamos a buscar quién es el cliente al otro microservicio
        try {
            UsuarioDTO user = usuarioFeign.buscarPorID(carrito.getIdUsuario());
            if (user != null) {
                dto.setNombreCliente(user.getNombre() + " " + user.getApellido());
                dto.setCorreoCliente(user.getEmail());
            } else {
                dto.setNombreCliente("Usuario Desconocido");
                dto.setCorreoCliente("Sin correo");
            }
        } catch (Exception e) {
            // Si el servicio de usuarios está apagado, no se cae todo el programa
            dto.setNombreCliente("Servicio de usuarios caído");
            dto.setCorreoCliente("Desconocido");
        }

        return dto;
    }

    public Carrito save(Carrito c){
        // Pegamos al puerto 8080 (Usuario)
        UsuarioDTO user = usuarioFeign.buscarPorID(c.getIdUsuario());
        if (user == null) {
            throw new RuntimeException("Usuario no existe en la base de datos");
        }

        // Pegamos al puerto 8083 (Inventario)
        InventarioDTO inv = inventarioFeign.buscarPorId(c.getCodigoProducto(), c.getCantidad());

        if (inv == null || inv.getStock() < c.getCantidad()) {
            throw new RuntimeException("No hay stock suficiente. Revisa el inventario.");
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