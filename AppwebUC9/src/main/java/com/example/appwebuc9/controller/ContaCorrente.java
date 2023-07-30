package com.example.appwebuc9.controller;

import com.example.appwebuc9.model.ContaCorrentePf;

public interface ContaCorrente {

    Double sacar (Double quantidade, Conta conta);

    void deepositar(Double quantidade, Conta conta);

    void transferir(Double quantidade, Conta conta);

    Double consultaSaldo(ContaCorrentePf conta);
}
