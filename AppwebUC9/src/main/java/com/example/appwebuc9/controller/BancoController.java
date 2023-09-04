package com.example.appwebuc9.controller;


import com.example.appwebuc9.model.AccountType;
import com.example.appwebuc9.model.Conta;
import com.example.appwebuc9.model.ContaCorrentePf;
import com.example.appwebuc9.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;

@Service
public class BancoController implements ContaCorrente {


   // @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;

   // @Override
    //public Double sacar(Double quantidade, Conta conta){return null;}

    @Override
    public void deepositar(Double quantidade, Conta conta) {

    }

    public ContaCorrentePf criarConta(String name, String accountType) throws Exception {
        ContaCorrentePf contaCorrentePf = null;
        ContaCorrentePf contaCorrentepf = new ContaCorrentePf();
        StringBuilder message = new StringBuilder();
        if(accountType == null){
            message.append("É necessário informar o tipo da conta");
        }
        switch (accountType){
            case "POUPANCA" :
                contaCorrentePf.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE" :
                contaCorrentePf.setAccountType(AccountType.CONTA_CORRENTE);
                break;
            default:
                message.append("\nTipo de conta não suportado!");
        }
        Person person = controller.findPerson(name);
        if(person != null && contaCorrentePf.getError() == null){
            number++;
            contaCorrentePf.setNumeroConta(number);
            contaCorrentePf.setPerson(person);
            bancoRepository.save(contaCorrentePf);
        }else if(contaCorrentePf.getError() == null) {

            message.append("\nPessoa ");
            message.append(name).append("informada não cadastrada!");
        }
        if(!message.isEmpty()){
            contaCorrentePf.setError(message.toString());
        }

        return contaCorrentePf;
    }

    public ContaCorrentePf consultaConta(String name){

        List<ContaCorrentePf> contas = (List<ContaCorrentePf>) bancoRepository.findAll();

        for(ContaCorrentePf cc : contas){
            if(cc.getPerson() != null && cc.getPerson().getName().equals(name)){

                if(cc.getDataAtualizacao().equals(new Date())){
                    return cc;
                }else{
                    cc.setDataAtualizacao( new Date());
                    cc.setSaldo(cc.getSaldo() * 1.001);
                    bancoRepository.save(cc);

                }

            }
        }
        return null;
    }
    @Override
    public void depositar(Double quantidade, Conta conta){
        Double total = conta.getSaldo() + quantidade;
        conta.setSaldo(total);
    }
    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor){
        String message = "";
        ContaCorrentePf destino = bancoRepository.findById(contaDestino).get();
        ContaCorrentePf origem = bancoRepository.findById(contaOrigem).get();

        if(!origem.getAccountType().equals(destino.getAccountType())){
            if (origem.getAccountType() != destino.getAccountType()){
                if (origem.getAccountType() == AccountType.CONTA_POUPANCA || destino.getAccountType() == AccountType.CONTA_POUPANCA){
                    valor += 10.0;
                }
            }
        }

        if(origem.getSaldo() >= valor){
            destino.setSaldo(destino.getSaldo() + valor );
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = "A conta do(a) " + destino.getPerson().getName() + "recebeu a transferencia no valor de R$ " + valor;
        }else{
            message = message + "Saldo insuficiente para a transação!";
        }
        return message;
    }

    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    @Override
    public Double consultaSaldo(ContaCorrentePf conta) { return conta.getSaldo();}

    public void calcularJurosPoupanca() {
        List<ContaCorrentePf> contasPoupanca = bancoRepository.findByAccountType(AccountType.CONTA_POUPANCA);
        for (ContaCorrentePf conta : contasPoupanca){
            Double saldoAtual = conta.getSaldo();
            Double jurosDiarios = saldoAtual * 0.001;
            conta.setSaldo( saldoAtual + jurosDiarios);
            bancoRepository.save(conta);
        }
    }
}

