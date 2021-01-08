package com.devensaio.hremployee.interfaces;


import com.devensaio.hremployee.entities.Employee;
import com.devensaio.hremployee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.tools.java.Environment;

import java.util.List;

@Component
@RequiredArgsConstructor
@RefreshScope
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeRepository repository;

    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    Environment env;

    @Value("${test.config}")
    public String config;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity insert(@RequestBody Employee employee){
        try {
            repository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){

        logger.info("SERVICO REQUISITADO");
        Employee wk = repository.findById(id).get();
        return ResponseEntity.ok(wk);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> getAllConfig(){

        logger.info("CONFIG = "+ config);
        return ResponseEntity.noContent().build();
    }
}
