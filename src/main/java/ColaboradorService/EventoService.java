package ColaboradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ColaboradorEntities.EventoEntity;
import ColaboradorRepository.EventoRepository;

@Service
public class EventoService {
 

    @Autowired
    private EventoRepository eventoRepository;

    public EventoEntity criarEvento(EventoEntity evento) {
        return eventoRepository.save(evento);
    }

    public List<EventoEntity> listarEventos() {
        return eventoRepository.findAll();
    }
}