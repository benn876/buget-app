package org.fasttrackit.bugetapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fasttrackit.bugetapp.model.Transaction;
import org.fasttrackit.bugetapp.model.filter.TransactionFilter;
import org.fasttrackit.bugetapp.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {
    private final TransactionService service;

    @GetMapping
    public List<Transaction> getAllTransactions(TransactionFilter filter) {
        log.info("GET all transactions");
        return service.getAll(filter);
    }
}
