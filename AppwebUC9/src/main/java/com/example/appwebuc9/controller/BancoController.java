package com.example.appwebuc9.controller;


import com.example.appwebuc9.model.ContaCorrentePf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoController implements ContaCorrente {

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private Controller controller;

    private Long number = 0L;

    @Override
    public Double sacar(Double quantidade, Conta conta){return null;}

    public ContaCorrentePf criarConta(String name) throws Exception {
        ContaCorrentePf contaCorrentepf = new ContaCorrentePf();
        number++;
        contaCorrentePf.setNumeroConta(number);
        Person person = controller.findPerson(name);
        if(person != null){
            contaCorrentePf.setPerson(person);
            bancoRepository.save(contaCorrentePf);
        }else {
            throw new Exception("Pessoa não está cadastrada!");
        }
        return contaCorrentePf;
    }

    public ContaCorrentePf consultaConta(String name){
        List<ContaCorrentePf> contas = (List<ContaCorrentePf>) bancoRepository.findAll();

        for(ContaCorrentePf cc : contas){
            if(cc.getPerson() != null && cc.getPerson().getName().equals(name)){
                return cc;
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
    public void transferir(Double quantidade, Conta conta){

    }

    @Override
    public Double consultaSaldo(ContaCorrentePf conta) { return conta.getSaldo();}
}
