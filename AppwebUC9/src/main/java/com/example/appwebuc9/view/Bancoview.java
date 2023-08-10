package com.example.appwebuc9.view;

import com.example.appwebuc9.controller.BancoController;
import com.example.appwebuc9.model.AccountType;
import com.example.appwebuc9.model.ContaCorrentePf;
import com.example.appwebuc9.model.ContaPoupanca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

    @RestController
    public class Bancoview {

    @Autowired
    private BancoController bancoController;

    @PostMapping("/criaconta")
    public ContaCorrentePf criarConta(@PathParam("name")String name, @PathParam("type")String type) throws Exception {
        return bancoController.criarConta(name, type);
    }

    @GetMapping("/type")
    public String listAccountType(){
        String text = AccountType.CONTA_CORRENTE + ", " + AccountType.CONTA_POUPANCA;

        return text;
    }

    @GetMapping("/consultaconta")
    public ContaCorrentePf consultaConta(@PathParam("name")String name) {
        return bancoController.consultaConta(name);
    }

    @PutMapping("/transferir")
    public String transferir(@PathParam("contaOrigem") Long contaOrigem, @PathParam("contaDestino") Long contaDestino, @PathParam("valor") Double valor){
        return bancoController.transferir(contaOrigem, contaDestino, valor);
    }

}
