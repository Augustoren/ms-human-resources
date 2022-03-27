package com.augustoren.hrpayroll.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augustoren.hrpayroll.models.PaymentModel;
import com.augustoren.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/{workerId}/days/{daysWorked}")
	public ResponseEntity<PaymentModel> getPayment(@PathVariable("workerId") UUID workerId, @PathVariable("daysWorked") Integer days){
		return paymentService.getPayment(workerId, days);
	}
}
