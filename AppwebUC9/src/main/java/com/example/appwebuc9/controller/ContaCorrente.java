package com.example.appwebuc9.controller;

import com.example.appwebuc9.model.Conta;
import com.example.appwebuc9.model.ContaCorrentePf;

public interface ContaCorrente {


    Double sacar (Double quantidade, Conta conta);

    void deepositar(Double quantidade, Conta conta);

    void depositar(Double quantidade, Conta conta);

    String transferir(Long contaOrigem, Long contaDestino, Double valor);

    Double consultaSaldo(ContaCorrentePf conta);
}
