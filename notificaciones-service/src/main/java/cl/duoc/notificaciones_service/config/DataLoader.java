package cl.duoc.notificaciones_service.config;

import cl.duoc.notificaciones_service.model.Notificacion;
import cl.duoc.notificaciones_service.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private NotificacionRepository notificacionRepository;


    @Override
    public void run(String... args) throws Exception {
        if (notificacionRepository.count()== 0){
            Notificacion n1 = new Notificacion(null,"TRK-123456", "DESPACHADO", "En centro de distribución", "pedro@gmail.com");
            Notificacion n2 = new Notificacion(null,"TRK-681357", "DESPACHADO", "En proceso de despacho", "matias@hotmail.com");
            Notificacion n3 = new Notificacion(null,"TRK-181636", "DESPACHADO", "Llegando al destiuno", "byron@gmail.com");

            notificacionRepository.save(n1);
            notificacionRepository.save(n2);
            notificacionRepository.save(n3);


        }
    }
}
