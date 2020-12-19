package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PaymentService {

    @Value("${integration.hr-worker.baseUrl}")
    private String baseUrl;

    RestTemplate client = new RestTemplate();

    public Payment getPayment(Long workerId, Integer days){
        Map<String, Long> params = new HashMap<>();
        params.put("id", workerId);
        Worker worker = client.getForObject(baseUrl +"/worker/{id}", Worker.class, params);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
