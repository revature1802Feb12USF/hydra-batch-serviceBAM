package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Batch;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Joshua Boudreau (1802-Matt)
 * @author Sonam Sherpa (1802-Matt)
 * @author Marko Miocic (1802-Matt)
 */
@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	public List<Batch> findByTrainerID(Integer trainerID);

	public List<Batch> findByEndDateLessThan(Timestamp curr);
	public List<Batch> findByTrainerIDAndEndDateLessThan(int trainerID, Timestamp curr);

	public List<Batch> findByStartDateGreaterThan(Timestamp curr);
	public List<Batch> findByTrainerIDAndStartDateGreaterThan(int trainerID, Timestamp curr);

	public List<Batch> findByStartDateLessThanAndEndDateGreaterThan(Timestamp start, Timestamp end);
	public Batch findByTrainerIDAndStartDateLessThanAndEndDateGreaterThan(int trainerID, Timestamp start, Timestamp end);
}