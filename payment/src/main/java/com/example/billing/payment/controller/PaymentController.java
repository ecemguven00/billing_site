package com.example.billing.payment.controller;


import com.example.billing.payment.model.Payment;
import com.example.billing.payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestParam String invoiceId, @RequestParam Double amount) {
        Payment payment = paymentService.createPayment(invoiceId, amount);
        return ResponseEntity.ok(payment); // Ödeme oluşturmak için
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<List<Payment>> getPaymentsByInvoiceId(@PathVariable String invoiceId) {
        List<Payment> payments = paymentService.getPaymentsByInvoiceId(invoiceId);
        return ResponseEntity.ok(payments); //Belirli bir invoiceId ile ilişkilendirilmiş ödemeleri almak için
    }

    @PutMapping("/update-status/{paymentId}")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Long paymentId, @RequestParam String status) {
        Optional<Payment> payment = paymentService.updatePaymentStatus(paymentId, status);
        return payment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}


