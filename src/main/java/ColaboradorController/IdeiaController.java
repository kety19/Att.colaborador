package ColaboradorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ColaboradorEntities.IdeiaEntity;
import ColaboradorService.IdeiaService;


@RestController
@RequestMapping("/ideias")
public class IdeiaController {


    @Autowired
    private IdeiaService ideiaService;

    @PostMapping
    public ResponseEntity<IdeiaEntity> postarIdeia(@RequestBody IdeiaEntity ideia) {
        IdeiaEntity novaIdeia = ideiaService.postarIdeia(ideia);
        return ResponseEntity.ok(novaIdeia);
    }

    @GetMapping
    public ResponseEntity<List<IdeiaEntity>> listarIdeias() {
        return ResponseEntity.ok(ideiaService.listarIdeias());
    }
}
