package com.revature.batch.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
	
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
//	@Test
//	public void getAllBatches_returnsNonEmptyResult() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		batch.add(new Batch(null, null, null, null, new BatchType(1, null, null)));
//		when(mockBatchService.getAllBatches()).thenReturn(batch);
//		
//		// Execute
//		List<Batch> result = batchCrudController.getAllBatches();
//		
//		// Verify
//		assertTrue(!result.isEmpty());
//	}
//	
//	@Test
//	public void getAllBatches_returnsCorrectInstanceof() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		batch.add(new Batch(null, null, null, null, new BatchType(1, null, null)));
//		when(mockBatchService.getAllBatches()).thenReturn(batch);
//		
//		// Execute
//		List<Batch> result = batchCrudController.getAllBatches();
//		
//		// Verify
//		assertTrue(result.get(0) instanceof Batch);
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getAllBatches_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		when(mockBatchService.getAllBatchesByTrainerID(1)).thenReturn(batch);
//		
//		// Execute
//		batchCrudController.getAllBatches();
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getPastBatches_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		when(mockBatchService.getAllBatchesByTrainerID(1)).thenReturn(batch);
//		
//		// Execute
//		batchPastController.getPastBatches();
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getFutureBatches_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		when(mockBatchService.getAllBatchesByTrainerID(1)).thenReturn(batch);
//		
//		// Execute
//		batchFutureController.getFutureBatches();
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getCurrentBatch_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		when(mockBatchService.getAllBatchesByTrainerID(1)).thenReturn(batch);
//		
//		// Execute
//		batchCurrentController.getCurrentBatches();
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getCurrentBatches_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<Batch> batch = new ArrayList<Batch>();
//		when(mockBatchService.getAllBatchesByTrainerID(1)).thenReturn(batch);
//		
//		// Execute
//		batchCurrentController.getCurrentBatches();
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getBatchById_returnsCorrectException() throws NoBatchException {
//		// Setup
//		Batch batch = new Batch();
//		when(mockBatchService.getBatchById(1)).thenReturn(batch);
//		
//		// Execute
//		batchController.getBatchById(2);
//	}
//	
//	@Test(expected = BatchUpdateException.class)
//	public void updateBatch_returnsCorrectException() throws BatchUpdateException {
//		// Setup
//		Batch batch = new Batch();
//		when(mockBatchService.updateBatch(batch)).thenReturn(batch);
//		
//		// Execute
//		batchCrudController.updateBatch(new Batch());
//	}
//	
//	@Test(expected = NoBatchException.class)
//	public void getAllBatchTypes_returnsCorrectException() throws NoBatchException {
//		// Setup
//		List<BatchType> batches = new ArrayList<BatchType>();
//		when(mockBatchService.getAllBatchTypes()).thenReturn(batches);
//		
//		// Execute
//		batchTypeController.getAllBatchTypes();
//	}
	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Simple Unit Test.  Tests to determine if RestAssured worked. Batch inside H2 database with batchId of 1
	 */
	@Test
	public void testRestAssured(){
		
		Response resp = RestAssured.get("http://localhost:8888/api/v2/batches/1");//.andReturn();
		
		String json = resp.getBody().asString();
		
		JsonPath jsonPath = new JsonPath(json);
		Assert.assertEquals("1", jsonPath.getString("id"));
		
	}

	
	/**
	 * @author FEB-1802 Marko Miocic, Matt's Branch
	 * 
	 *  Simple Unit Test.  Tests to determine if RestAssured worked. Batch inside H2 database with batchId of 1
	 */
	@Test
	public void testRestAssuredDotThen() {
		
		RestAssured.get("http://localhost:9001/api/v2/batches/1").then().body("id", equalTo("1"));
	
	}
	
}
