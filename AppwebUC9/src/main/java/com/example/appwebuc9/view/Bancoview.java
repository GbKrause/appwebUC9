package com.example.appwebuc9.view;

import com.example.appwebuc9.model.ContaCorrentePf;
import com.example.appwebuc9.model.ContaPoupanca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Bancoview {
    @Autowired
    private BancoController bancoController;
    @GetMapping("/consultaSaldo")
    public Double consultaSaldo(){
        ContaCorrentePf conta = new ContaCorrentePf();
        conta.setSaldo(100D);
        return bancoController.consultaSaldo(conta);
    }

    @PostMapping("/criaconta")
    public ContaCorrentePf criarConta(@PathParam("name")String name) throws Exception {
        return bancoController.criarConta(name);
    }

    @GetMapping("/consultaconta")
    public ContaCorrentePf consultaConta(@PathParam("name")String name) {return bancoController.consultaConta(name);}

}
