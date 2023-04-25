package org.fasttrackit.bugetapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.bugetapp.model.Transaction;
import org.fasttrackit.bugetapp.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.fasttrackit.bugetapp.model.TransactionType.BUY;
import static org.fasttrackit.bugetapp.model.TransactionType.SELL;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {
    private final TransactionRepository repository;

    @Override
    public void run(String... args) {
        log.info("Runner is populating with data");
        repository.saveAll(List.of(
                Transaction.builder()
                        .product("laptop")
                        .type(BUY)
                        .amount(4000D)
                        .build(),
                Transaction.builder()
                        .product("phone")
                        .type(SELL)
                        .amount(2000D)
                        .build(),
                Transaction.builder()
                        .product("iPhone")
                        .type(SELL)
                        .amount(2400D)
                        .build()
        ));
    }
}
