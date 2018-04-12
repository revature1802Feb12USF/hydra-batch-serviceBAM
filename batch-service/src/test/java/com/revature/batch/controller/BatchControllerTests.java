package com.revature.batch.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.batch.bean.Batch;
import com.revature.batch.exception.BatchUpdateException;
import com.revature.batch.exception.NoBatchException;
import com.revature.batch.service.BatchService;
import com.revature.batch.service.TrainerService;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BatchControllerTests {
	
	TrainerService mockTrainerService = mock(TrainerService.class);
	BatchService mockBatchService = mock(BatchService.class);
	BatchController batchController = new BatchController(mockBatchService);
	BatchCrudController batchCrudController = new BatchCrudController(mockBatchService);
	BatchCurrentController batchCurrentController = new BatchCurrentController(mockBatchService);
	BatchFutureController batchFutureController = new BatchFutureController(mockBatchService);
	BatchPastController batchPastController = new BatchPastController(mockBatchService);	

	
	/**
	 * @author FEB-1802 Marko Miocic and Sonam Sherpa,  Matt's Branch
	 * 
	 *  Simple Unit Test.  Tests to determine if RestAssured worked. Batch inside H2 database with batchId of 1
	 */
	@Test
	public void testRestAssuredDotThen() {	
		RestAssured.get("http://localhost:9001/api/v2/batches/batch/1").then().body("trainerID", equalTo(50));
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test.  Tests to get all batches that are hardcoded
	 */
	@Test
	public void restAssuredTestGetAllBatches() {
		RestAssured.get("http://localhost:9001/api/v2/batches/").then().body("[0].trainerID", equalTo(50))
		.and().body("[1].trainerID", equalTo(51)).and().body("[2].trainerID", equalTo(61))
		.and().body("[3].trainerID", equalTo(50)).and().body("[4].trainerID", equalTo(50));
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test.  Tests to get all batches by TrainerID. This test test trainerId==50
	 */
	@Test
	public void restAssuredTestGetBatchByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/50").then();
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test.  Tests to update a batch
	 *  Changes batch with id of 1 from batch name of 1801 to 1802
	 */
	@Test
	public void restAssuredTestUpdateBatch() {	
		Map<String,String> batch = new HashMap<>();
		batch.put("id", "1");
        batch.put("name", "1802");
        batch.put("startDate", "1516683600000");
        batch.put("endDate", "1521777600000");
        batch.put("trainerID", "50");
        batch.put("curriculumID", "10");
        batch.put("scheduleID", "100");
        
        RestAssured.given().contentType("application/json").body(batch)
        .when().put("http://localhost:9001/api/v2/batches/").then().statusCode(200);
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all current batches
	 */
	@Test
	public void restAssuredTestGetCurrentBatches() {

		
		RestAssured.get("http://localhost:9001/api/v2/batches/current/").then()
		.body("[0].trainerID", equalTo(61)).and().body("[1].trainerID", equalTo(50));
	
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all current batches by trainer ID
	 *  This test tests for trainerID==50
	 */
	@Test
	public void restAssuredTestGetCurrentBatchesByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/current/50").then();
	
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all future batches
	 */
	@Test
	public void restAssuredTestGetFutureBatches() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/future/").then()
		.body("[0].trainerID", equalTo(50));
	
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all future batches by trainer ID
	 *  This test tests for trainerID==50
	 */
	@Test
	public void restAssuredTestGetFutureBatchesByTrainerID() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/future/50").then();
	
	}

	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all past batches
	 */
	@Test
	public void restAssuredTestGetPastBatches() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/past/").then()
		.body("[0].trainerID", equalTo(50)).and().body("[1].trainerID", equalTo(51));
	
	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Rest Assured Test to get all past batches by trainer ID
	 *  This test tests for trainerID==50
	 */
	@Test
	public void restAssuredTestGetPastBatchesByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/past/50").then();
	
	}
	
	
}
