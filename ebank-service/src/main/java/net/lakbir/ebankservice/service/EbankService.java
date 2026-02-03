package net.lakbir.ebankservice.service;


import lombok.AllArgsConstructor;
import net.lakbir.ebankservice.entities.BankAccount;
import net.lakbir.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lakbir.abderrahim on 03/02/2026
 */

@Service
@AllArgsConstructor
public class EbankService {

    private BankAccountRepository bankAccountRepository;

    public List<BankAccount> getBankAccounts(){
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccount(String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank account not found"));
    }

    public List<BankAccount> getBankAccountsByCustomerId(long customerId){
        return bankAccountRepository.findByCustomerId(customerId);
    }

    public BankAccount saveBankAccount(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }
}
