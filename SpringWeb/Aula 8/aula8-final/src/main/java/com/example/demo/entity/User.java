package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OrderBy
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @Size(min = 3, max = 8)
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;
    
    @Email
    @NotBlank(message = "O campo e-mail é obrigatório")
    private String email;
    
    public User() {
    }
    
    public User(long id) {
        this();
        this.id = id;
    }

    public User(String nome, String email, String senha) {
        this();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
