package com.revature.batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.batch.bean.BatchType;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.service.BatchService;

/**
 * 
 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
 * Last edited: 4/10/18
 * Batch: 1802-Feb12-java-matt
 * 
 * Endpoints:
 * getAllBatchTypes() 			- get - batches/types/
 * 
 * handles ZUUL endpoint /batches
 * 
 * A BatchType describes the main focus of a Batch
 * Ex. Java, .NET, etc.
 *
 */
@RestController
@RequestMapping(value = "/types")
public class BatchTypeController {
	
	@Autowired
	BatchService batchService;

	public BatchTypeController() {
		super();
	}

	public BatchTypeController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}
	
	/**
	 * A method to get all batch types using BatchService.
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * @return a list of batch types, Http status 200 otherwise Http status 204
	 */
	@GetMapping("/")
	public List<BatchType> getAllBatchTypes() {

		List<BatchType> batchTypes = batchService.getAllBatchTypes();

		if (batchTypes.isEmpty()) {
			throw new NoBatchException("No batch types exist");
		}
		return batchTypes;
	}

}
