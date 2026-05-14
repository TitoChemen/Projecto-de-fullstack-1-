package cl.duoc.descuentos_service.service;

import cl.duoc.descuentos_service.dto.DescuentoDTO;
import cl.duoc.descuentos_service.mapper.DescuentoMapper;
import cl.duoc.descuentos_service.model.Descuento;
import cl.duoc.descuentos_service.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoService {
    @Autowired
    private DescuentoRepository descuentoRepository;

    @Autowired
    private DescuentoMapper descuentoMapper;

    public List<Descuento> findAll(){
        return descuentoRepository.findAll();
    }

    public DescuentoDTO findById(Long id){
        Descuento descuento = descuentoRepository.findById(id).orElse(null);
        return descuentoMapper.toDTO(descuento);
    }

    public Descuento save(Descuento d){
        return descuentoRepository.save(d);
    }

    public void delete(Long id){
        descuentoRepository.deleteById(id);
    }

    public Descuento update(Long id , Descuento descuento){
        Descuento descuentoAplicado = descuentoRepository.findById(id).orElse(null);
        if (descuentoAplicado == null) return null;
        descuentoAplicado.setMontoOriginal(descuento.getMontoOriginal());
        descuentoAplicado.setMontoDescuento(descuento.getMontoDescuento());

        return descuentoRepository.save(descuentoAplicado);
    }
}
