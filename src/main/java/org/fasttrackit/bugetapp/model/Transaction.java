package org.fasttrackit.bugetapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRANSACTION_TABLE")
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String product;
    @Column
    private TransactionType type;
    @Column
    private Double amount;
}
