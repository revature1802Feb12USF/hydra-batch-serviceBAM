package com.revature.batch.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.revature.batch.logging.JSONify;

@Entity
@Table(name = "Batch_Type")
public class BatchType {

	@Id
	@Column(name = "Batch_Type_ID")
	@SequenceGenerator(name = "BATCH_TYPE_ID_SEQ", sequenceName = "BATCH_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_TYPE_ID_SEQ")
	private Integer id;

	@Column(name = "Batch_Type_Name")
	private String name;

	@Column(name = "Batch_Type_Length") 
	private Integer length = 10; 

	public BatchType() {
		super();
	}

	public BatchType(Integer id, String name, Integer length) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
	}

	public BatchType(String name, Integer length) {
		super();
		this.name = name;
		this.length = length;
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

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "BatchType [\n" + "(ID) \t id =" + id + ",\n" 
				+ "(Name) \t name =" + name + ",\n"
				+ "(Length) \t length =" + length + ",\n]";
	}

}