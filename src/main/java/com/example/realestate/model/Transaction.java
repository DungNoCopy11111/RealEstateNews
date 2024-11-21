package com.example.realestate.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private ListingPackage listingPackage;



    private BigDecimal amount;
    private LocalDateTime purchaseDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String paymentMethod;
    private String paymentStatus;
}
