package com.devsuperior.hrpayroll.interfaces.clients;

import com.devsuperior.hrpayroll.entities.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="hr-employee", path = "/employee")
public interface EmployeeClient {

    @GetMapping("/{id}")
    ResponseEntity<Employee> findById(@PathVariable Long id);
}
