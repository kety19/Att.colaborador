package ColaboradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ColaboradorEntities.IdeiaEntity;
import ColaboradorRepository.IdeiaRepository;

@Service
public class IdeiaService {

	@Autowired
    private IdeiaRepository ideiaRepository;

    public IdeiaEntity postarIdeia(IdeiaEntity ideia) {
        return ideiaRepository.save(ideia);
    }

    public List<IdeiaEntity> listarIdeias() {
        return ideiaRepository.findAll();
    }
}
