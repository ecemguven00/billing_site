package com.example.billing.payment.service;

import com.example.billing.payment.model.Payment;
import com.example.billing.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(String invoiceId, Double amount) {
        Payment payment = new Payment();
        payment.setInvoiceId(invoiceId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");
        payment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByInvoiceId(String invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId);
    }

    public Optional<Payment> updatePaymentStatus(Long paymentId, String status) {
        Optional<Payment> paymentOpt = paymentRepository.findById(paymentId);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            payment.setStatus(status);
            paymentRepository.save(payment);
        }
        return paymentOpt;
    }
}