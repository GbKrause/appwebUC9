package com.example.appwebuc9.model;


public abstract class Conta {

    private Long numeroConta;

    //private Person pessoa;

    private Double saldo;


    public Long getNumeroConta() {return numeroConta;}

    public void setNumeroConta(Long numeroConta) { this.numeroConta = numeroConta;}

    /*
    public Person getPessoa(){
        return pessoa;
    }

    public void setPerson(Person pessoa) {
        this.pessoa= pessoa;
    }
     */

    public Double getSaldo(){return saldo;}

    public void setSaldo(Double saldo){ this.saldo = saldo;}
}
