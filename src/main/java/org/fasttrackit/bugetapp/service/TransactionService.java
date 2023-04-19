package org.fasttrackit.bugetapp.service;

import org.fasttrackit.bugetapp.model.Transaction;
import org.fasttrackit.bugetapp.model.TransactionType;
import org.fasttrackit.bugetapp.model.filter.TransactionFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Service
public class TransactionService {
    private final List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getAll(TransactionFilter filter) {
        if (filter == null) {
            return transactions;
        }
        Stream<Transaction> transactionStream = transactions.stream();
        if (filter.product() != null) {
            transactionStream = transactionStream.filter(transaction -> filter.product().equals(transaction.product()));
        }
        if (filter.type() != null) {
            transactionStream = transactionStream.filter(transaction -> filter.type().equals(transaction.type()));
        }
        return transactionStream.toList();
    }

    public Map<TransactionType, List<Transaction>> getGroupedByType() {
        return transactions.stream().collect(groupingBy(Transaction::type));
    }
}
