package com.example.colaboradores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ColaboradorEntities.IdeiaEntity;
import ColaboradorService.IdeiaService;

public class IdeiaTest {



    @Autowired
    private IdeiaService ideiaService;

    @Test
    public void testPostarIdeiaComDadosValidos() {
        IdeiaEntity ideia = new IdeiaEntity();
        ideia.setNome("Automatização de processos");
        ideia.setDescricao("Melhoria de processos repetitivos.");
        ideia.setImpacto("Alto impacto");
        ideia.setCustoEstimado(10000.0);

        IdeiaEntity salvo = ideiaService.postarIdeia(ideia);
        assertNotNull(salvo);
        assertEquals("Automatização de processos", salvo.getNome());
    }

    @Test
    public void testPostarIdeiaSemDescricao() {
        IdeiaEntity ideia = new IdeiaEntity();
        ideia.setNome("Automatização de processos");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ideiaService.postarIdeia(ideia);
        });

        assertEquals("A descrição da ideia é obrigatória", exception.getMessage());
    }

    @Test
    public void testAvaliarIdeiaComNotaValida() {
        IdeiaEntity ideia = new IdeiaEntity();
        ideia.setNome("Ideia de Redução de Custos");

        double nota = 8.5;
        ideiaService.avaliarIdeia(ideia, nota);

        assertEquals(nota, ideia.getNota());
    }

    @Test
    public void testAvaliarIdeiaComNotaInvalida() {
        IdeiaEntity ideia = new IdeiaEntity();
        ideia.setNome("Ideia de Redução de Custos");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            ideiaService.avaliarIdeia(ideia, 12);
        });

        assertEquals("A nota deve estar entre 3 e 10", exception.getMessage());
    }

}
