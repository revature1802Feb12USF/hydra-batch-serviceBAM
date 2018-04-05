package com.revature.batch.service;

import java.sql.Timestamp;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.bean.Batch;
import com.revature.batch.bean.BatchType;
import com.revature.batch.repository.BatchRepository;
import com.revature.batch.repository.BatchTypeRepository;

@Service
public class BatchService {
	@Autowired
	BatchRepository batchRepository;

	@Autowired
	BatchTypeRepository batchTypeRepository;

	public BatchService() {
		super();
	}

	public BatchService(BatchRepository batchRepository, BatchTypeRepository batchTypeRepository) {
		super();
		this.batchRepository = batchRepository;
		this.batchTypeRepository = batchTypeRepository;
	}

	public Batch addOrUpdateBatch(Batch b) {
		if (b != null && b.getType() != null && b.getType().getId() != null) {
			Integer typeId = b.getType().getId();
			if (batchTypeRepository.exists(typeId)) {
				BatchType batchType = batchTypeRepository.findOne(typeId);
				b.setType(batchType);
			} else {
				b.getType().setId(null);
			}
		}
		return batchRepository.save(b);
	}

	public Batch getBatchById(Integer id) {
		return batchRepository.findOne(id);
	}

	public List<Batch> getBatchAll() {
		return batchRepository.findAll();
	}

	public List<Batch> getBatchByTrainerID(Integer trainerID) {
		return trainerID == null ? null : batchRepository.findByTrainerID(trainerID);
	}

	public List<BatchType> getAllBatchTypes() {
		return batchTypeRepository.findAll();
	}

	/**
	 * Method to get all currently active batches
	 * @author Francisco Palomino | Batch: 1712-dec10-java-steve
	 * @return a list of batches, Http status 200 otherwise Http status 204
	 */
	public List<Batch> currentBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByEndDateGreaterThanAndStartDateLessThan(t, t);
	}

	/**
	 * Populates batch using a list of curriculum subtopics.
	 * NOTE: This method assumes all batches start on a Monday.
	 * @author DillonT
	 * @param currSubtopics
	 * @param batch
	 */
}