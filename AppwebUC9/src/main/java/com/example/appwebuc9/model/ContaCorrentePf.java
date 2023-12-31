package com.example.appwebuc9.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.JoinColumn;
import java.util.Date;
import java.beans.Transient;


//@Entity
//@Table(name = "conta")
public class ContaCorrentePf {
  // @Id
   // @Column(name = "numero_conta")
    private Long numeroConta;

    //private Person pessoa;

    private Double saldo;

    //@OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    //@Column(name = "type")
    private AccountType accountType;

    //@Column
    private Date dataAtualizacao;

    //@Transient utilizado para nao enviar ao BD
    private String error;

    public Date getDataAtualizacao(){
      return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao){
      this.dataAtualizacao = dataAtualizacao;
    }

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Person getPerson() {return person;}

    public void setPerson(Person person){this.person = person;}

    public Long getNumeroConta(){return numeroConta;}

    public void setNumeroConta(Long numeroConta){this.numeroConta = numeroConta; }

    /*
    public Person getPessoa(){
    return pessoa;
    }

    public void setPessoa(Person pessoa) {
    this.pessoa = pessoa;
    }
     */

    public Double getSaldo(){return saldo;}

    public void setSaldo(Double saldo){this.saldo = saldo;}
}
