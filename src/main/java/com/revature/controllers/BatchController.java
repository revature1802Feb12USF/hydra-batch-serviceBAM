package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Batch;
import com.revature.exceptions.NoBatchException;
import com.revature.services.BatchService;

/**
 * handles ZUUL endpoint /batches
 * 
 * GET( /batches/batch/{batchID} ) - Returns the batch with specific {batchID}
 * 
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
 */
@RestController
@RequestMapping(value = "/batch")
public class BatchController {

	@Autowired
	BatchService batchService;

	public BatchController() {
		super();
	}

	public BatchController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}

	/**
	 * method to get batch by batch id using BatchService.
	 * 
	 * @author Josh Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @param Http request that holds the batch id as parameter.
	 * @return a Batch object, Http status 200 otherwise Http status 204.
	 */
	@GetMapping("/{batchID}")
	public Batch getBatchById(@PathVariable int batchID) {
		Batch result = batchService.getBatchById(batchID);
		if (result == null) {
			throw new NoBatchException("The batch was not found");
		}
		return result;
	}
}
