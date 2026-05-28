package cl.duoc.facturaciones_service.repository;

import cl.duoc.facturaciones_service.model.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturacionRepository extends JpaRepository<Facturacion, Long> {
    ScopedValue<Object> findByIdPago(Long idPago);
}
