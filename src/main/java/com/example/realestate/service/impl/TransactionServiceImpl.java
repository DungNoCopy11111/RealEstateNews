package com.example.realestate.service.impl;

import com.example.realestate.repository.TransactionRepository;
import com.example.realestate.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public BigDecimal Revenue() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monthStart = now.minusMonths(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime previousMonthStart = monthStart.minusMonths(1);
        return transactionRepository.calculateRevenueBetween(monthStart, now);
    }
}
