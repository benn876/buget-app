package org.fasttrackit.bugetapp.repository;

import org.fasttrackit.bugetapp.model.Transaction;
import org.fasttrackit.bugetapp.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where (t.product=:product or :product is null)" +
            " and (t.type=:type or :type is null ) and (t.amount >= :minAmount or :minAmount is null) and (t.amount <= :maxAmount or :maxAmount is null)")
    List<Transaction> findByFilter(String product, String type, Double minAmount, Double maxAmount);
}
