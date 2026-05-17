package cl.duoc.pagos_service.config;

import cl.duoc.pagos_service.model.Pago;
import cl.duoc.pagos_service.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PagoRepository pagoRepository;


    @Override
    public void run(String... args) throws Exception {
        if (pagoRepository.count()== 0){
            Pago p1 = new Pago( null, null, 25000, "Debito", "TAB-TEC-069", "APROBADO");
            Pago p2 = new Pago( null, null, 1000, "Debito", "TIK-TOK-123", "APROBADO");
            Pago p3 = new Pago( null, null, 100000, "Debito", "TDEM-ONI-666", "APROBADO");
            Pago p4 = new Pago( null, null, 259000, "Debito", "DEF-ABC-123", "APROBADO");

            pagoRepository.save(p1);
            pagoRepository.save(p2);
            pagoRepository.save(p3);
            pagoRepository.save(p4);


        }
    }
}

