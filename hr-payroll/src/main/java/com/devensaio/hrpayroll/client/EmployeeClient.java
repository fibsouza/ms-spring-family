package com.devensaio.hrpayroll.client;

import com.devensaio.hrpayroll.entities.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name="hr-employee", path = "/employee")
public interface EmployeeClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}")
    Employee findById(@PathVariable Long id);

    @GetMapping(value = "/all")
    List<Employee> getAllEmployees();
}
