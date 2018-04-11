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
 * getCurrentBatches() 		- get - /batches/current/
 * getCurrentBatch() 		- get - /batches/current/{trainerID}
 * Batch: 1802-Feb12-java-matt
 * 
 * handles ZUUL endpoint /batches
 *
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
	 * A method to get all current batches using BatchService.
	 * 
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * @return a list of all current batches, 
	 * 		Http status 200, otherwise Http status 204
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * A method to get all current batches for a specific trainer using BatchService.
	 * 
	 * @param Http request that holds trainer id as a parameter
	 * 
	 * @return a Batch object for the current batch for the trainer, 
	 * 		Http status 200, otherwise Http status 204
	 */
	@GetMapping("/{trainerID}")
	public Batch getCurrentBatch(@PathVariable int trainerID) {

		Batch batch = batchService.getCurrentBatchByTrainerID(trainerID);

		if (batch == null) {
			throw new NoBatchException("No current batch exists for trainerID = " + trainerID);
		}
		return batch;
	}

}
