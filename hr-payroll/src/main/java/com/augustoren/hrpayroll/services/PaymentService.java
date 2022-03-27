package com.augustoren.hrpayroll.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.augustoren.hrpayroll.feignclients.WorkerFeignClient;
import com.augustoren.hrpayroll.models.PaymentModel;
import com.augustoren.hrpayroll.models.WorkerModel;

@Service
public class PaymentService {
	
	@Autowired
	WorkerFeignClient workerFeignClient;

	public ResponseEntity<PaymentModel> getPayment(UUID workerId, int days) {
		
		WorkerModel worker = workerFeignClient.listOne(workerId).getBody();
		
		return ResponseEntity.status(HttpStatus.OK).body(new PaymentModel(worker.getName(), worker.getDailyIncome(), days));
	}
}
