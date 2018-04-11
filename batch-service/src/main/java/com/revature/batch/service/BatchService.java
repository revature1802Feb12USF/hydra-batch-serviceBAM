package com.revature.batch.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.batch.bean.Batch;
import com.revature.batch.repository.BatchRepository;

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

	public List<Batch> getAllBatches() {
		return batchRepository.findAll();
	}

	public List<Batch> getAllBatchesByTrainerID(int trainerID) {
		return batchRepository.findByTrainerID(trainerID);
	}

	public List<Batch> getPastBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByEndDateLessThan(t);
	}

	public List<Batch> getPastBatchesByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndEndDateLessThan(trainerID, t);
	}

	public List<Batch> getFutureBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByStartDateGreaterThan(t);
	}

	public List<Batch> getFutureBatchesByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndStartDateGreaterThan(trainerID, t);
	}

	public List<Batch> getCurrentBatches() {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByStartDateLessThanAndEndDateGreaterThan(t, t);
	}

	public Batch getCurrentBatchByTrainerID(int trainerID) {
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return batchRepository.findByTrainerIDAndStartDateLessThanAndEndDateGreaterThan(trainerID, t, t);
	}

	public Batch getBatchById(int id) {
		return batchRepository.findOne(id);
	}
	
	public Batch createBatch(Batch b) {
		return batchRepository.save(b);
	}

	public Batch updateBatch(Batch b) {
		return batchRepository.save(b);
	}
}