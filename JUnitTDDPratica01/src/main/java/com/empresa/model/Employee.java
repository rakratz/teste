package com.empresa.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Employee {
    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(max= 100, message = "Nome não pode ter mais do que 100 caracteres")
    private String nome;
    
    private String email;
    private String departamento;

    public Employee(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Employee(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Employee(Long id, String nome, String email, String departamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }
}
