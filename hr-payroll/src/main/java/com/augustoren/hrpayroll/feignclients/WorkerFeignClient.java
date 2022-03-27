package com.augustoren.hrpayroll.feignclients;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.augustoren.hrpayroll.models.WorkerModel;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {
	
    @GetMapping("/{id}")
    ResponseEntity<WorkerModel> listOne(@PathVariable("id") UUID workerId);

}
