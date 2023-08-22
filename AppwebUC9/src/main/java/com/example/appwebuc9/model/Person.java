package com.example.appwebuc9.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;


//@Entity
public class Person {

    //@Id
    private Integer id;

    private String name;

    private String sexo;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private ContaCorrentePf contaCorrentePf;

    public ContaCorrentePf getContaCorrentePf() {return contaCorrentePf;}

    public void setContaCorrentePf(ContaCorrentePf contaCorrentePf) {this.contaCorrentePf = contaCorrentePf;}

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
