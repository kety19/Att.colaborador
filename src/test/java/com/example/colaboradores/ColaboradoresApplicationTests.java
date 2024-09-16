package com.example.colaboradores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ColaboradorEntities.ColaboradorEntity;
import ColaboradorService.ColaboradorService;

@SpringBootTest
class ColaboradoresApplicationTests {

    @Autowired
    private ColaboradorService colaboradorService;

    @Test
    public void testCadastrarColaboradorComDadosValidos() {
        ColaboradorEntity colaborador = new ColaboradorEntity();
        colaborador.setNome("Maria");
        colaborador.setEmail("maria@empresa.com");
        colaborador.setSenha("senha123");
        colaborador.setPerfil("COLABORADOR");

        ColaboradorEntity salvo = colaboradorService.cadastrarColaborador(colaborador);
        assertNotNull(salvo);
        assertEquals("Maria", salvo.getNome());
    }

    @Test
    public void testCadastrarColaboradorComEmailDuplicado() {
        ColaboradorEntity colaborador = new ColaboradorEntity();
        colaborador.setNome("João");
        colaborador.setEmail("joao@empresa.com");
        colaborador.setSenha("senha123");
        colaborador.setPerfil("COLABORADOR");

        colaboradorService.cadastrarColaborador(colaborador);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            colaboradorService.cadastrarColaborador(colaborador);
        });

        assertEquals("E-mail já cadastrado", exception.getMessage());
    }

    @Test
    public void testAlterarPerfilParaAvaliador() {
        ColaboradorEntity colaborador = new ColaboradorEntity();
        colaborador.setNome("Pedro");
        colaborador.setEmail("pedro@empresa.com");
        colaborador.setPerfil("COLABORADOR");

        colaboradorService.alterarPerfil(colaborador, "AVALIADOR");
        assertEquals("AVALIADOR", colaborador.getPerfil());
    }

    @Test
    public void testAlterarPerfilParaAdmin() {
        ColaboradorEntity colaborador = new ColaboradorEntity();
        colaborador.setNome("Ana");
        colaborador.setEmail("ana@empresa.com");
        colaborador.setPerfil("COLABORADOR");

        colaboradorService.alterarPerfil(colaborador, "ADMIN");
        assertEquals("ADMIN", colaborador.getPerfil());
    }


}
