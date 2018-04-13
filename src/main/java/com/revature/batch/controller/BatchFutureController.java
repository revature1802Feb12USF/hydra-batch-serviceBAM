package com.revature.batch.controller;

import java.util.List;

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
 * Last edited: 4/10/18
 * Batch: 1802-Feb12-java-matt
 * 
 * handles ZUUL endpoint /batches
 * 
 * Endpoints:
 * getFutureBatches() 				- get - batches/future/
 * getFutureBatchesByTrainerID() 	- get - batches/future/{trainerID}
 */
@RestController
@RequestMapping(value = "/future")
public class BatchFutureController {
	
	@Autowired
	BatchService batchService;

	public BatchFutureController() {
		super();
	}

	public BatchFutureController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}
	
	/**
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * A method to get all future batches using BatchService.
	 * @return a list of all future batches, 
	 * 		Http status 200, otherwise Http status 204
	 */
	@GetMapping("/")
	public List<Batch> getFutureBatches() {

		List<Batch> batches = batchService.getFutureBatches();

		if (batches == null) {
			throw new NoBatchException("No future batches exist");
		}
		return batches;
	}

	/**
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * A method to get all future batches for a specific trainer using BatchService.
	 * 
	 * @param Http request that holds trainer id as a parameter.         
	 * @return a list of future batches for a specific trainer, 
	 * 		Http status 200, otherwise Http status 204
	 */
	@GetMapping("/{trainerID}")
	public List<Batch> getFutureBatchesByTrainerID(@PathVariable int trainerID) {

		List<Batch> batches = batchService.getFutureBatchesByTrainerID(trainerID);

		if (batches == null) {
			throw new NoBatchException("No future batches for trainerID = " + trainerID);
		}
		return batches;
	}

}
