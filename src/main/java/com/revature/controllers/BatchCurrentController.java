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
 * GET( /batches/current/ ) - Returns all current batches
 * GET( /batches/current/{trainerID} ) - Returns the current batches with specific {trainerID}
 * 
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
 */
@RestController
@RequestMapping(value = "/current")
public class BatchCurrentController {
	
	@Autowired
	BatchService batchService;

	public BatchCurrentController() {
		super();
	}

	public BatchCurrentController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}
	
	/**
	 * method to get all current batches using BatchService
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return a list of all current batches, Http status 200, otherwise Http status 204
	 */
	@GetMapping("/")
	public List<Batch> getCurrentBatches() {

		List<Batch> batches = batchService.getCurrentBatches();

		if (batches.isEmpty()) {
			throw new NoBatchException("No current batches exist");
		}
		return batches;
	}

	/**
	 * method to get all current batches for a specific trainer using BatchService
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @param Http request that holds trainer id as a parameter
	 * @return a Batch object for the current batch for the trainer, 
	 * 		Http status 200, otherwise Http status 204
	 */
	@GetMapping("/{trainerID}")
	public List<Batch> getCurrentBatch(@PathVariable int trainerID) {
		List<Batch> batches = batchService.getCurrentBatchByTrainerID(trainerID);

		if (batches == null) {
			throw new NoBatchException("No current batch exists for trainerID = " + trainerID);
		}
		return batches;
	}

}
