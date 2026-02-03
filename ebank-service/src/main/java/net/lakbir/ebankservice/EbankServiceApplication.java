package net.lakbir.ebankservice;

import net.lakbir.ebankservice.entities.BankAccount;
import net.lakbir.ebankservice.repository.BankAccountRepository;
import net.lakbir.ebankservice.service.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EbankService ebankService){
        return args -> {
            for(int i = 1; i <= 3; i++){
                for(int j = 1; j <= 5; j++){
                    ebankService.saveBankAccount(BankAccount.builder()
                                    .type(Math.random() > 0.5 ? "CURRENT_ACCOUNT" : "SAVING_ACCOUNT")
                                    .balance(1000 + Math.random() * 60000)
                                    .customerId(i)
                            .build());
                }
            }
        };
    }
}
