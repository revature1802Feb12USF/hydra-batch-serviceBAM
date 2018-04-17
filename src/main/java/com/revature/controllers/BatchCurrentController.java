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
 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
 * Last edited: 4/10/18
 * 
 * handles ZUUL endpoint /batches
 * 
 * GET( /batches/current/ ) - Returns all current batches
 * GET( /batches/current/{trainerID} ) - Returns the current batches with specific {trainerID}
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
	 * Last edited: 4/10/18
	 * 
	 * method to get all current batches using BatchService
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
	 * Last edited: 4/10/18
	 * 
	 * method to get all current batches for a specific trainer using BatchService
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
