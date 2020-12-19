package com.devsuperior.hrworker.interfaces;

import com.devsuperior.hrworker.entities.WorkerEntity;
import com.devsuperior.hrworker.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.Work;
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
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    private Environment env;
    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private final WorkerRepository repository;


    @GetMapping("/all")
    public ResponseEntity<List<WorkerEntity>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerEntity> findById(@PathVariable Long id){

        logger.info("PORT = " + env.getProperty("local.server.port"));
        WorkerEntity wk = repository.findById(id).get();
        return ResponseEntity.ok(wk);
    }
}
