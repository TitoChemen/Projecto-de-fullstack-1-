package cl.duoc.inventario_service.config;

import cl.duoc.inventario_service.model.Inventario;
import cl.duoc.inventario_service.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private InventarioRepository inventarioRepository;


    @Override
    public void run(String... args) throws Exception {
        if (inventarioRepository.count()== 0){
            Inventario i1 = new Inventario(null,50, "Pasillo A-12", "DISPONIBLE", 1L);
            Inventario i2 = new Inventario(null,0, "Pasillo b-12", "SIN_STROCK", 2L);
            Inventario i3 = new Inventario(null,21, "Pasillo A-2", "DISPONIBLE", 3L);
            Inventario i4 = new Inventario(null,89, "Pasillo C-4", "DISPONIBLE", 4L);

            inventarioRepository.save(i1);
            inventarioRepository.save(i2);
            inventarioRepository.save(i3);
            inventarioRepository.save(i4);


        }
    }
}
