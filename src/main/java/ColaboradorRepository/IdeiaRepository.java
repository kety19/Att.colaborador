package ColaboradorRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import ColaboradorEntities.IdeiaEntity;

public interface IdeiaRepository extends JpaRepository<IdeiaEntity, Long> {
}
