package com.revature.controllers;

import java.util.List;

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
 * GET( /batches/future/ ) - Returns all future batches
 * GET( /batches/future/{trainerID} ) - Returns the future batches with specific {trainerID}
 * 
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
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
	 * A method to get all future batches using BatchService.
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return a list of all future batches, Http status 200, otherwise Http status 204
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
	 * A method to get all future batches for a specific trainer using BatchService.
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
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
