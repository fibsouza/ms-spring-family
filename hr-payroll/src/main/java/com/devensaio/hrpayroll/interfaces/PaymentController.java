package com.devensaio.hrpayroll.interfaces;

import com.devensaio.hrpayroll.entities.Employee;
import com.devensaio.hrpayroll.entities.Payment;
import com.devensaio.hrpayroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RefreshScope
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {


    private final PaymentService service;

    @GetMapping("/{employeeId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long employeeId, @PathVariable Integer days){
        Payment payment = service.getPayment(employeeId, days);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/allString")
    public String getString(){
        return "Teste teste teste";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployees());
    }
}
