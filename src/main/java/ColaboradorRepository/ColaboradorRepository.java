package ColaboradorRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ColaboradorEntities.ColaboradorEntity;

public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Long> {
    Optional<ColaboradorEntity> findByEmail(String email);
}