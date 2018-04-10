package com.revature.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.batch.bean.Batch;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.service.BatchService;

/**
 * 
 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
 * Batch: 1802-Feb12-java-matt
 * 
 * handles ZUUL endpoint /batches
 *
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
	 * A method to get batch by batch id using BatchService.
	 * 
	 * @param Http request that holds the batch id as parameter.
	 * 
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
