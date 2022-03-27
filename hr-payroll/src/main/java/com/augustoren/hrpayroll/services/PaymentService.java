package com.augustoren.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.augustoren.hrpayroll.models.PaymentModel;
import com.augustoren.hrpayroll.models.WorkerModel;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<PaymentModel> getPayment(UUID workerId, int days) {
		
		Map<String, String> uriParams = new HashMap<>();
		uriParams.put("workerId", "" + workerId);
		
		WorkerModel worker = restTemplate.getForObject(workerHost + "/workers/{workerId}", WorkerModel.class, uriParams);
		
		return ResponseEntity.status(HttpStatus.OK).body(new PaymentModel(worker.getName(), worker.getDailyIncome(), days));
	}
}
