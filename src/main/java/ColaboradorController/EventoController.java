package ColaboradorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ColaboradorEntities.EventoEntity;
import ColaboradorService.EventoService;

@RestController
@RequestMapping("/Evento")
public class EventoController {


    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<EventoEntity> criarEvento(@RequestBody EventoEntity evento) {
        EventoEntity novoEvento = eventoService.criarEvento(evento);
        return ResponseEntity.ok(novoEvento);
    }

    @GetMapping
    public ResponseEntity<List<EventoEntity>> listarEventos() {
        return ResponseEntity.ok(eventoService.listarEventos());
    }
}
