package ColaboradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import ColaboradorEntities.EventoEntity;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {
}