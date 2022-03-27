package com.augustoren.hrworker.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augustoren.hrworker.model.WorkerModel;

public interface WorkerRepository extends JpaRepository<WorkerModel, UUID> {
	
	boolean existsByEmail(String email);
	
}
