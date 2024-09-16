package ColaboradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ColaboradorEntities.ColaboradorEntity;
import ColaboradorRepository.ColaboradorRepository;

@Service
public class ColaboradorService {


    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ColaboradorEntity cadastrarColaborador(ColaboradorEntity colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public List<ColaboradorEntity> listarTodos() {
        return colaboradorRepository.findAll();
    }
}
