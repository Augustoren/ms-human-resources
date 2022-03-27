package com.augustoren.hrworker.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustoren.hrworker.Dtos.WorkerDto;
import com.augustoren.hrworker.model.WorkerModel;
import com.augustoren.hrworker.services.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<WorkerModel>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.getAllWorkers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listOne(@PathVariable("id") UUID workerId) {
        return workerService.getWorkerById(workerId);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid WorkerDto workerDto){
        return workerService.createWorker(workerDto);
    }
}
