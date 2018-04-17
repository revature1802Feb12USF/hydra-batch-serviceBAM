package com.revature.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.revature.controllers.BatchController;
import com.revature.controllers.BatchCrudController;
import com.revature.controllers.BatchCurrentController;
import com.revature.controllers.BatchFutureController;
import com.revature.controllers.BatchPastController;
import com.revature.services.BatchService;

import io.restassured.RestAssured;

public class BatchControllerTests {
	
	BatchService mockBatchService = mock(BatchService.class);
	BatchController batchController = new BatchController(mockBatchService);
	BatchCrudController batchCrudController = new BatchCrudController(mockBatchService);
	BatchCurrentController batchCurrentController = new BatchCurrentController(mockBatchService);
	BatchFutureController batchFutureController = new BatchFutureController(mockBatchService);
	BatchPastController batchPastController = new BatchPastController(mockBatchService);	

	
	/**
	 * Tests to determine if RestAssured worked. Batch inside H2 database with batchId of 1
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void testRestAssuredDotThen() {	
		RestAssured.get("http://localhost:9001/api/v2/batches/batch/1").then().body("trainerID", equalTo(50));
	}
	
	/**
	 * Rest Assured Test to get all batches
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetAllBatches() {
		RestAssured.get("http://localhost:9001/api/v2/batches/").then().body("[0].trainerID", equalTo(50))
		.and().body("[1].trainerID", equalTo(51)).and().body("[2].trainerID", equalTo(61))
		.and().body("[3].trainerID", equalTo(50)).and().body("[4].trainerID", equalTo(50));
	}
	
	/**
	 * Rest Assured Test to get all batches by TrainerID. (trainerId==50)
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetBatchByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/50").then().body("[0].trainerID", equalTo(50))
		.and().body("[1].trainerID", equalTo(50)).and().body("[2].trainerID", equalTo(50));
	}
	
	/**
	 * Rest Assured Test to update a batch
	 *  	Changes batch with id of 1 from batch name of 1801 to 1802
	 *  
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
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
	 * Rest Assured Test to get all current batches
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetCurrentBatches() {

		
		RestAssured.get("http://localhost:9001/api/v2/batches/current/").then()
		.body("[0].trainerID", equalTo(61)).and().body("[1].trainerID", equalTo(50));
	
	}
	
	/**
	 * Rest Assured Test to get all current batches by trainer ID
	 *  	This test tests for trainerID==50
	 *  
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetCurrentBatchesByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/current/50").then().body("id", equalTo(4));
	
	}
	
	/**
	 * Rest Assured Test to get all future batches
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetFutureBatches() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/future/").then()
		.body("[0].trainerID", equalTo(50));
	
	}
	
	/**
	 * Rest Assured Test to get all future batches by trainer ID
	 *  	This test tests for trainerID==50
	 *  
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetFutureBatchesByTrainerID() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/future/50").then().body("[0].id", equalTo(5));
	
	}

	
	/**
	 * Rest Assured Test to get all past batches
	 * 
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetPastBatches() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/past/").then()
		.body("[0].trainerID", equalTo(50)).and().body("[1].trainerID", equalTo(51));
	
	}
	
	/**
	 * Rest Assured Test to get all past batches by trainer ID
	 *  	This test tests for trainerID==50
	 *  
	 * @author FEB-1802 Marko Miocic, Sonam Sherpa and Josh Boudreau (1802-Matt)
	 */
	@Test
	public void restAssuredTestGetPastBatchesByTrainerID() {
		RestAssured.get("http://localhost:9001/api/v2/batches/past/50").then().body("[0].id", equalTo(1));
	
	}
	
	
}
