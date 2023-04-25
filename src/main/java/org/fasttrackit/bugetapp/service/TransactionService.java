package org.fasttrackit.bugetapp.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.bugetapp.model.Transaction;
import org.fasttrackit.bugetapp.model.TransactionType;
import org.fasttrackit.bugetapp.model.filter.TransactionFilter;
import org.fasttrackit.bugetapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;

    public List<Transaction> getAll(TransactionFilter filter) {
        if (filter == null) {
            return repository.findAll();
        }
        return repository.findByFilter(filter.product(), ofNullable(filter.type()).map(Enum::name).orElse(null), filter.minAmount(), filter.maxAmount());
    }

    public Map<TransactionType, List<Transaction>> getGroupedByType() {
        return repository.findAll().stream().collect(groupingBy(Transaction::getType));
    }
}
