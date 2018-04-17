package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Batch;
import com.revature.repositories.BatchRepository;

/**
 * @author Joshua Boudreau, Sonam Sherpa, Marko Miocic (1802-Matt)
 * Last updated: 4/10/18
 */
@Service
public class BatchService {
	
	@Autowired
	BatchRepository batchRepository;

	public BatchService() {
		super();
	}

	public BatchService(BatchRepository batchRepository) {
		super();
		this.batchRepository = batchRepository;
	}

	/**
	 * Gets all batches
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all batches
	 */
	public List<Batch> getAllBatches() {
		return batchRepository.findAll();
	}

	/**
	 * Gets all batches by trainer id
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all batches with specific trainer id
	 * @param id of the trainer
	 */
	public List<Batch> getAllBatchesByTrainerID(int trainerID) {
		return batchRepository.findByTrainerID(trainerID);
	}

	/**
	 * Gets all past batches
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all past batches
	 */
	public List<Batch> getPastBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByEndDateLessThan(t);
	}

	/**
	 * Gets all past batches by trainer id
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all past batches with specific trainer id
	 * @param id of the trainer
	 */
	public List<Batch> getPastBatchesByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndEndDateLessThan(trainerID, t);
	}

	/**
	 * Gets all future batches
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all future batches
	 */
	public List<Batch> getFutureBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByStartDateGreaterThan(t);
	}

	/**
	 * Gets all future batches by trainer id
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all future batches with specific trainer id
	 * @param id of the trainer
	 */
	public List<Batch> getFutureBatchesByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndStartDateGreaterThan(trainerID, t);
	}

	/**
	 * Gets all currently active batches
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return List of all currently active batches
	 */
	public List<Batch> getCurrentBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByStartDateLessThanAndEndDateGreaterThan(t, t);
	}

	/**
	 * Gets currently active batch by trainer id
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return Currently active batche with specific trainer id
	 * @param id of the trainer
	 */
	public Batch getCurrentBatchByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndStartDateLessThanAndEndDateGreaterThan(trainerID, t, t);
	}

	/**
	 * Gets a single batch by its id
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return Batch with specific id
	 * @param id of the batch
	 */
	public Batch getBatchById(int id) {
		return batchRepository.findOne(id);
	}
	
	/**
	 * Creates a batch
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return Created batch
	 * @param batch to be created
	 */
	public Batch createBatch(Batch b) {
		return batchRepository.save(b);
	}

	/**
	 * Updates a batch
	 * 
	 * @author Marko Miocic (1802-Matt)
	 * 
	 * @return Updated batch
	 * @param batch to be created
	 */
	public Batch updateBatch(Batch b) {
		return batchRepository.save(b);
	}
}