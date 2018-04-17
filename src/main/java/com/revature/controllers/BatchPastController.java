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
 * GET( /batches/past/ ) - Returns all past batches
 * GET( /batches/past/{trainerID} ) - Returns the past batches with specific {trainerID}
 * 
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
 */
@RestController
@RequestMapping(value = "/past")
public class BatchPastController {
	
	@Autowired
	BatchService batchService;

	public BatchPastController() {
		super();
	}

	public BatchPastController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}
	
	/**
	 * A method to get all past batches using BatchService.
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return a list of all past batches, Http status 200 otherwise Http status 204
	 */
	@GetMapping("/")
	public List<Batch> getPastBatches() {

		List<Batch> batches = batchService.getPastBatches();

		if (batches.isEmpty()) {
			throw new NoBatchException("No past batches exist");
		}
		return batches;
	}

	/**
	 * A method to get all past batches for a specific trainer using BatchService.
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 *   
	 * @param Http request that holds trainer id as a parameter.
	 * @return a list of past batches for the trainer, Http status 200 otherwise Http status 204
	 */
	@GetMapping("/{trainerID}")
	public List<Batch> getPastBatchesByTrainerId(@PathVariable int trainerID) {

		List<Batch> batches = batchService.getPastBatchesByTrainerID(trainerID);

		if (batches.isEmpty()) {
			throw new NoBatchException("No past batches exist with trainerID = " + trainerID);
		}
		return batches;
	}

}
