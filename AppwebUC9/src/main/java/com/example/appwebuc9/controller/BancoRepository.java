package com.example.appwebuc9.controller;


import com.example.appwebuc9.model.AccountType;
import com.example.appwebuc9.model.ContaCorrentePf;



import java.util.List;

public interface BancoRepository extends CrudRepository<ContaCorrentePf, Long> {
    List<ContaCorrentePf> findByAccountType(AccountType accountType);
}


