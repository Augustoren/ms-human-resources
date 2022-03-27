package com.augustoren.hrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.augustoren.hrworker.Dtos.WorkerDto;
import com.augustoren.hrworker.model.WorkerModel;
import com.augustoren.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository workerRepository;

    public List<WorkerModel> getAllWorkers(){
        return workerRepository.findAll();
    }

    public ResponseEntity<Object> getWorkerById(UUID workerId){
        Optional<WorkerModel> workerModel = workerRepository.findById(workerId);
        if(!workerModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Worker not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(workerModel.get());
    }

    @Transactional
    public ResponseEntity<Object> createWorker(WorkerDto workerDto) {
    	WorkerModel workerModel = new WorkerModel();
    	BeanUtils.copyProperties(workerDto, workerModel);
    	
    	if(workerRepository.existsByEmail(workerModel.getEmail())) {
    		return ResponseEntity.status(400).body("Worker already exists.");
    	}
    	
    	return ResponseEntity.status(201).body(workerRepository.save(workerModel));

    }
}
