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
<<<<<<< HEAD
	 * A method to get all batches using BatchService.
	 * 
	 * @return a list of all batches, Http status 200 otherwise Http status 204
	 */
	@GetMapping("")
	public List<Batch> getBatchAll() {
		List<Batch> result = batchService.getBatchAll();

		if (result == null || result.isEmpty()) {
			throw new NoBatchException("No batches exist");
		}
		return result;
	}

	/**
	 * A method to get all past batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all past batches for the trainer, Http status 200 otherwise
	 *         Http status 204
	 */
	@GetMapping("/past/{email}/")
	public List<Batch> getPastBatches(@PathVariable String email) {
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("No past batches exist");
		}

		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.before(b.getEndDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no past batches");
		}
		return batches;
	}

	/**
	 * A method to get all future batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all future batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("/future/{email}/")
	public List<Batch> getFutureBatches(@PathVariable String email) {
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("No future batches");
		}

		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.after(b.getStartDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no future batches");
		}
		return batches;
	}

	/**
	 * A method to get all in-progress batches for the trainer using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all in-progress batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("/inprogress/{email}/")
	public Batch getBatchInProgress(@PathVariable String email) {
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("no bathces in progress");
		}

		Batch batchInProgress = null;
		Timestamp t = new Timestamp(System.currentTimeMillis());
		for (Batch b : batches) {
			if (t.after(b.getStartDate()) && t.before(b.getEndDate())) {
				batchInProgress = b;
				break;
			}
		}
		if (batchInProgress == null) {
			throw new NoBatchException("no batches in progress");
		}
		return batchInProgress;
	}

	/**
	 * A method to get all in-progress for the trainer batches using BatchService.
	 * 
	 * @param request
	 *            Http request hold the trainer email as parameter.
	 * @return a list of all in-progress batches for the trainer, Http status 200
	 *         otherwise Http status 204
	 */
	@GetMapping("/allinprogress/{email}/")
	public List<Batch> getAllBatchesInProgress(@PathVariable String email) {
		List<Batch> batches = batchService.getBatchByTrainerID(trainerService.getTrainerByEmail(email));
		if (batches == null) {
			throw new NoBatchException("no batches in progress");
		}

		Timestamp t = new Timestamp(System.currentTimeMillis());
		batches.removeIf(b -> t.before(b.getStartDate()) || t.after(b.getEndDate()));
		if (batches.isEmpty()) {
			throw new NoBatchException("no batches in progress");
		}
		return batches;
	}

	/**
=======
>>>>>>> master
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
