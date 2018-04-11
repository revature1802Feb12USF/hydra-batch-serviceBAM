package com.revature.batch.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "BATCH")
public class Batch {

	@Id
	@Column(name = "BATCH_ID")
	@SequenceGenerator(name = "BATCH_ID_SEQ", sequenceName = "BATCH_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_ID_SEQ")
	private Integer id;

	@Column(name = "BATCH_NAME")
	@NotNull(message = "Batch name cannot be empty")
	private String name;

	@Column(name = "START_DATE")
	@NotNull(message = "Start date cannot be empty")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	@NotNull(message = "End date cannot be empty")
	private Timestamp endDate;
	
	@Column(name = "TRAINER")
	@NotNull(message = "Trainer cannot be null")
	private Integer trainerID;
	
	@Column(name = "CURRICULUM_ID")
	@NotNull(message = "Curriculum cannot be null")
	private Integer curriculumID;
	
	@Column(name = "SCHEDULE_ID")
	@NotNull(message = "Schedule cannot be null")
	private Integer scheduleID;

	public Batch() {
		super();
	}
		
	public Batch(Integer id, String name, Timestamp startDate, Timestamp endDate, Integer trainerID, Integer curriculumID, Integer scheduleID) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainerID;
		this.curriculumID = curriculumID;
		this.scheduleID = scheduleID;
	}

	public Batch(String name, Timestamp startDate, Timestamp endDate, Integer trainerID, Integer curriculumID, Integer scheduleID) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerID = trainerID;
		this.curriculumID = curriculumID;
		this.scheduleID = scheduleID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(Integer trainerID) {
		this.trainerID = trainerID;
	}

	public Integer getCurriculumID() {
		return curriculumID;
	}

	public void setCurriculumID(Integer curriculumID) {
		this.curriculumID = curriculumID;
	}

	public Integer getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(Integer scheduleID) {
		this.scheduleID = scheduleID;
	}

	/*
	 * @author Josh Boudreau, Sonam Sherpa, Marko Miocic
	 * Last edited: 4/10/18
	 * Batch: 1802-Feb12-java-matt
	*/
	@Override
	public String toString() {
		return "Batch [\n" + "(Batch ID) \t id =" + id + ",\n" 
			+ "(Name) \t name =" + name + ",\n"
			+ "(StartDate) \t startDate =" + startDate + ",\n"
			+ "(EndDate) \t endDate =" + endDate +",\n"
			+ "(TrainerID) \t trainerID =" + trainerID + ",\n"
			+ "(ScheduleID) \t scheduleID =" + scheduleID + ",\n"
			+ "(CurriculumID) \t curriculumID =" + curriculumID + "\n]";

	}
	                                          
}
