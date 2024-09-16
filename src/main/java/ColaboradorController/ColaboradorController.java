package ColaboradorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ColaboradorEntities.ColaboradorEntity;
import ColaboradorService.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {


    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity<ColaboradorEntity> cadastrar(@RequestBody ColaboradorEntity colaborador) {
        ColaboradorEntity novoColaborador = colaboradorService.cadastrarColaborador(colaborador);
        return ResponseEntity.ok(novoColaborador);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorEntity>> listarTodos() {
        return ResponseEntity.ok(colaboradorService.listarTodos());
    }
}
