package cl.duoc.descuentos_service.config;

import cl.duoc.descuentos_service.model.Descuento;
import cl.duoc.descuentos_service.repository.DescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DescuentoRepository descuentoRepository;


    @Override
    public void run(String... args) throws Exception {
        if (descuentoRepository.count()== 0){
            Descuento d1 = new Descuento((Long) null, 20000L, 5000L);
            Descuento d2 = new Descuento((Long) null, 25000L, 6250L);
            Descuento d3 = new Descuento((Long) null, 40000L, 10000L);


            descuentoRepository.save(d1);
            descuentoRepository.save(d2);
            descuentoRepository.save(d3);


        }
    }
}

