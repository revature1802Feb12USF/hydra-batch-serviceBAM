package com.revature.batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.batch.bean.Batch;
import com.revature.batch.exception.BatchUpdateException;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.service.BatchService;

/**
 * 
 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
 * Last edited: 4/10/18
 * Batch: 1802-Feb12-java-matt
 * 
 * Endpoints:
 * getAllBatches() 				- get - /batches/
 * getAllBatchesByTrainerId() 	- get - /batches/{trainerID}
 * updateBatch() 				- put - /batches/
 * 
 * handles ZUUL endpoint /batches
 *
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
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * A method to get all batches using BatchService.
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
	 * A method to get all batches for a specific trainer using BatchService.
	 * 
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * @param Http request that holds trainer id as a parameter.
	 * 
	 * @return a list of batches for the trainer, 
	 * 		Http status 200 otherwise Http status 204
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
	 * A method to update batch using BatchService.
	 * 
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	 * 
	 * @param batch to be updated.
	 * 
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
