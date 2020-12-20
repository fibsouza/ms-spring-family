package com.devsuperior.hremployee.interfaces;

import com.devsuperior.hremployee.entities.Employee;
import com.devsuperior.hremployee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private Environment env;
    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository repository;


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id){

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("PORT = " + env.getProperty("local.server.port"));
        Employee wk = repository.findById(id).get();
        return ResponseEntity.ok(wk);
    }
}
