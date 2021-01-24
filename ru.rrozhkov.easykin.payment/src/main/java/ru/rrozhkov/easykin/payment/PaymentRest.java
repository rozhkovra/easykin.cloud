package ru.rrozhkov.easykin.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRest {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/")
    public Iterable<PaymentEntity> payments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public PaymentEntity person(@PathVariable Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
