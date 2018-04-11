package com.revature.batch.service.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.revature.batch.bean.Batch;
import com.revature.batch.repository.BatchRepository;
import com.revature.batch.service.BatchService;


public class BatchServiceTests {
	
//	BatchRepository mockBatchRepo = mock(BatchRepository.class);
//	Batch mockBatch = mock(Batch.class);
//	BatchService batchService = new BatchService(mockBatchRepo);
//
//	@Test
//	public void addOrUpdateBatch_returnsBatchWithCorrectTypeIdWhenExists() {
//		// Setup
//		Batch batch = new Batch(null, null, null, null, new BatchType(1, null, null));
//		when(mockBatchRepo.save(batch)).thenReturn(batch);
//		
//		// Execute
//		Batch returnBatch = batchService.updateBatch(batch);
//		
//		// Verify
//		Assert.notNull(returnBatch.getType().getId(), "not null");
//	}
//	
//	@Test
//	public void addOrUpdateBatch_returnsBatchWithNullTypeIdWhenNotExists() {
//		// Setup
//		Batch batch = new Batch(null, null, null, null, new BatchType(1, null, null));
//		when(mockBatchTypeRepo.exists(1)).thenReturn(false);
//		when(mockBatchRepo.save(batch)).thenReturn(batch);
//		
//		// Execute
//		Batch returnBatch = batchService.updateBatch(batch);
//		
//		// Verify
//		Assert.isNull(returnBatch.getType().getId(), "null");
//	}
//	
//	@Test
//	public void addOrUpdateBatch_returnsCorrectType() {
//		// Setup
//		Batch batch = new Batch(null, null, null, null, new BatchType(1, null, null));
//		when(mockBatchTypeRepo.exists(1)).thenReturn(false);
//		when(mockBatchRepo.save(batch)).thenReturn(batch);
//		
//		// Execute
//		Batch returnBatch = batchService.updateBatch(batch);
//		
//		// Verify
//		assertTrue(returnBatch.getType() instanceof BatchType);
//	}
//	
//	@Test
//	public void addOrUpdateBatch_returnsCorrectTypeId() {
//		// Setup
//		Batch batch = new Batch(null, null, null, null, new BatchType(1, null, null));
//		when(mockBatchTypeRepo.exists(1)).thenReturn(true);
//		when(mockBatchTypeRepo.findOne(1)).thenReturn(batch.getType());
//		when(mockBatchRepo.save(batch)).thenReturn(batch);
//		
//		// Execute
//		Batch returnBatch = batchService.updateBatch(batch);
//		
//		// Verify
//		assertTrue(returnBatch.getType().getId() instanceof Integer);
//	}
	
//	public Batch addOrUpdateBatch(Batch b) {
//		if (b != null && 
//			b.getType() != null && 
//			b.getType().getId() != null) {
//			
//			Integer typeId = b.getType().getId();
//			
//			if (batchTypeRepository.exists(typeId)) {
//				BatchType batchType = batchTypeRepository.findOne(typeId);
//				b.setType(batchType);
//			} else {
//				b.getType().setId(null);
//			}
//		}
//		return batchRepository.save(b);
//	}

}
