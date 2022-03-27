package com.augustoren.hrpayroll.services;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.augustoren.hrpayroll.models.PaymentModel;

@Service
public class PaymentService {

	public ResponseEntity<PaymentModel> getPayment(UUID workerId, int days) {
		return ResponseEntity.status(HttpStatus.OK).body(new PaymentModel("Bob", 200.0, days));
	}
}
