package com.devsuperior.hrpayroll.interfaces;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    @GetMapping(value = "/{employeeId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long employeeId, @PathVariable Integer days){
        Payment payment = service.getPayment(employeeId, days);
        return ResponseEntity.ok(payment);
    }
}
