package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Batch;
import com.revature.exceptions.BatchUpdateException;
import com.revature.exceptions.NoBatchException;
import com.revature.services.BatchService;

/**
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
 * 
 * handles ZUUL endpoint /batches
 * 
 * GET( /batches/ ) - Returns all batches
 * GET( /batches/{trainerID} ) - Returns the batch with specific {trainerID}
 * PUT( /batches/ ) - Updates any new values in current batch
 */
@RestController
public class BatchCrudController {
	
	@Autowired
	BatchService batchService;

	public BatchCrudController() {
		super();
	}

	public BatchCrudController(BatchService batchService) {
		super();
		this.batchService = batchService;
	}
	
	/**
	 * method to get all batches using BatchService.
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return a list of batches, Http status 200 otherwise Http status 204
	 */
	@GetMapping("/")
	public List<Batch> getAllBatches() {

		List<Batch> batches = batchService.getAllBatches();

		if (batches.isEmpty()) {
			throw new NoBatchException("No batches exist");
		}
		return batches;
	}
	
	/**
	 * method to get all batches for a specific trainer using BatchService
	 * 
	 * @author Joshua Boudreau (1802-Matt)
	 * @author Sonam Sherpa (1802-Matt)
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @param Http request that holds trainer id as a parameter.
	 * @return a list of batches for the trainer, Http status 200 otherwise Http status 204
	 */
	@GetMapping("/{trainerID}")
	public List<Batch> getAllBatchesByTrainerId(@PathVariable int trainerID) {

		List<Batch> batches = batchService.getAllBatchesByTrainerID(trainerID);

		if (batches.isEmpty()) {
			throw new NoBatchException("No batches exist");
		}
		return batches;
	}

	/**
	 * method to update batch using BatchService
	 * 
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
	 * Last edited: 4/10/18
	 * 
	 * @param batch to be updated.
	 * @return batch and Http status 202 otherwise Http status 400
	 */
	@PutMapping("/")
	public Batch updateBatch(@RequestBody Batch batch) {

		Batch updatedBatch = batchService.updateBatch(batch);

		if (updatedBatch == null) {
			throw new BatchUpdateException("Error updating the batch");
		}
		return updatedBatch;
	}

}
