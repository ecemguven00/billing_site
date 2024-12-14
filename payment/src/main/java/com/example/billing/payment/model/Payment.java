package com.example.billing.payment.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String invoiceId; // Associated invoice ID

    @Getter
    @Setter
    private Double amount; // Payment amount

    @Getter
    @Setter
    private String status; // Payment status: "PENDING", "COMPLETED", "FAILED"

    @Getter
    @Setter
    private LocalDateTime paymentDate; // Date of payment

}
