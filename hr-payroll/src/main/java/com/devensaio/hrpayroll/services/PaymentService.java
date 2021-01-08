package com.devensaio.hrpayroll.services;

import com.devensaio.hrpayroll.client.EmployeeClient;
import com.devensaio.hrpayroll.entities.Employee;
import com.devensaio.hrpayroll.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final EmployeeClient client;

    public Payment getPayment(Long workerId, Integer days){
        Employee employee = client.findById(workerId);
        return new Payment(employee.getName(), employee.getDailyIncome(), days);
    }

    public List<Employee> getAllEmployees(){
        List<Employee> list = client.getAllEmployees();
        return list;
    }
}
