package com.amemais.model;

import javax.persistence.*;

@Entity
@Table(name = "exames")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "pdf")
    String pdf;
    @Column(name = "data")
    String data;


    public Exam(String pdf, String data) {
        this.pdf = pdf;
        this.data = data;
    }

    public Exam() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return pdf + " [Data de Entrega: " + data + "]";
    }
}

