package cl.duoc.descuentos_service.repository;

import cl.duoc.descuentos_service.model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, Long> {
}
