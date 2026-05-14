package cl.duoc.notificaciones_service.mapper;

import cl.duoc.notificaciones_service.dto.NotificacionDTO;
import cl.duoc.notificaciones_service.model.Notificacion;
import org.springframework.stereotype.Component;

@Component
public class NotificacionMapper {
    public NotificacionDTO toDTO(Notificacion notificacion){
        if (notificacion == null) return null;
        NotificacionDTO dto = new NotificacionDTO();
        dto.setEmailNotificacion(notificacion.getEmailNotificacion()+
                notificacion.getCodSeguimiento()+
                notificacion.getRastreo()+
                notificacion.getEstadoEnv());
        return dto;
    }
}
