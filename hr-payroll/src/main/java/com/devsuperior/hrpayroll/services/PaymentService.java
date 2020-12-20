package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Employee;
import com.devsuperior.hrpayroll.interfaces.clients.EmployeeClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PaymentService {

    @Autowired
    private EmployeeClient client;

    public Payment getPayment(Long workerId, Integer days){
        Employee employee = client.findById(workerId).getBody();
        return new Payment(employee.getName(), employee.getDailyIncome(), days);
    }
}
