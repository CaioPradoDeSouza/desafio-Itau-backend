package com.caio.desafio_Itau_backend.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caio.desafio_Itau_backend.dto.StatisticsResponse;
import com.caio.desafio_Itau_backend.service.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
	
	private final TransactionService transactionService;
	
	public StatisticsController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public ResponseEntity<StatisticsResponse> getStatistics(){
		DoubleSummaryStatistics stats = transactionService.getStatistics();
		return ResponseEntity.ok(new StatisticsResponse(stats));
	}
}
