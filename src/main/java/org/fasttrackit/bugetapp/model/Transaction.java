package org.fasttrackit.bugetapp.model;

import lombok.Builder;

@Builder
public record Transaction(
        String id,
        String product,
        TransactionType type,
        Double amount
) {
}
