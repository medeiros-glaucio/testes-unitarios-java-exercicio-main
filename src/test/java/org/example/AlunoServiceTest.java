package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;


    @Test
    public void NaoDeveInserirAlunoComMatriculaDuplicada() {
        Aluno alunoTeste = new Aluno(1, "Eva", 35, "99999999911", "22222222222");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("99999999911");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunoTeste));

    }

    @Test
    public void NaoDeveInserirAlunoComCPFDuplicado() {
        Aluno alunoTeste = new Aluno(1, "Eva", 35, "99999999911", "22222222222");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("22222222222");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunoTeste));
    }

    @Test
    void NaoDeveInserirAlunoMenorDe18Anos() {
        Aluno alunoTeste = new Aluno(1, "Eva", 17, "99999999911", "22222222222");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(alunoTeste));
    }
}

