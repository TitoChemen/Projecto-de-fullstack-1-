package cl.duoc.carrito_service.service;

import cl.duoc.carrito_service.dto.CarritoDTO;
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

    public List<Carrito> findAll(){
        return carritoRepository.findAll();
    }

    public CarritoDTO findById(Long id){
        Carrito carrito = carritoRepository.findById(id).orElse(null);
        return carritoMapper.toDTO(carrito);
    }

    public Carrito save(Carrito c){
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
