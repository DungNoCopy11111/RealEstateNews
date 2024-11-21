package com.example.realestate.repository;

import com.example.realestate.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.status = 'ACTIVE' " +
            "AND t.paymentStatus = 'COMPLETED' " +
            "AND t.purchaseDate BETWEEN :start AND :end")
    BigDecimal calculateRevenueBetween(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
