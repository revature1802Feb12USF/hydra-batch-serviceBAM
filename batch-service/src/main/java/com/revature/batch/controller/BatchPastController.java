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
 * Endpoints:
 * getPastBatches() 				- get - batches/past/
 * getPastBatchesByTrainerId() 		- get - batches/past/{trainerID}
 * Batch: 1802-Feb12-java-matt
 * 
 * handles ZUUL endpoint /batches
 *
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * A method to get all past batches using BatchService.
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 *   
	 * A method to get all past batches for a specific trainer using BatchService.
	 * 
	 * @param Http request that holds trainer id as a parameter.
	 *
	 * @return a list of past batches for the trainer, 
	 * 			Http status 200 otherwise Http status 204
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
