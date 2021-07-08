package com.amemais.model;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "nomeCliente")
    String nomeCliente;
    @Column(name = "password")
    String password;
    @Column(name = "username", unique = true)
    String username;
    @ManyToOne
    @JoinColumn(name = "id_exames")
    Exam exame;

    public Client(String nomeCliente, String password, String username, Exam exame) {
        this.nomeCliente = nomeCliente;
        this.password = password;
        this.username = username;
        this.exame = exame;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Exam getExame() {
        return exame;
    }

    public void setExame(Exam exame) {
        this.exame = exame;
    }
}

