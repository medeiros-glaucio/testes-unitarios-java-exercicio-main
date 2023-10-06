package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class AlunoTest {
     private Aluno alunoTeste;

     @BeforeEach
     public void config() {
          alunoTeste = new Aluno(1, "Eva", 35,"11111111111", "22222222222");
     }

     @Test
     public void ImpedirMatriculaDiferenteDe11Digitos(){
          Assertions.assertThrows(RuntimeException.class, () -> alunoTeste.setMatricula("7777777"));
     }

     @Test
     public void ImpedirMatriculaContendoCaracterEspecial(){
          Assertions.assertThrows(RuntimeException.class, () -> alunoTeste.setMatricula("999999999%9"));
     }
}
