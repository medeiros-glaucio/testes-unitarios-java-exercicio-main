package org.example;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private String matricula;
    private String cpf;

    public Aluno(int id, String nome, int idade, String matricula, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if((matricula.length() != 11) || !(matricula.matches("^[0-9]+$"))) {
            throw new RuntimeException("Matricula deve conter 11 caracteres numericos, sem caracteres especiais");
        }
        else
            this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}