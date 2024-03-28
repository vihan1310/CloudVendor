package com.cloudvendor.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.internal.runners.TestClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cloudvendor.entity.CloudVendor;
import com.cloudvendor.repository.CloudVendorRepository;

class CloudVendorServiceTest {
	
	@Mock //inorder to get database responses we are mocking it
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	CloudVendor cloudVendor;
	AutoCloseable autoCloseable; //to clpse unwanted resoures when the entire class execution get fineshed.
	

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable=MockitoAnnotations.openMocks(this);//this will open mock here and we r assign it to autocloseable as its func is to close all the resources.
		cloudVendorService=new CloudVendorService(cloudVendorRepository);
		cloudVendor=new CloudVendor(10,"Amazon","usa","7999103212");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		autoCloseable.close();
	}

	@Test
	void testGetCloudVendorById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCloudVendor() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCloudVendor() {
		
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		when(cloudVendorRepository.existsById(cloudVendor.getVendorId())).thenReturn(false);
		assertThat(cloudVendorService.addCloudVendor(cloudVendor).getVendorName()).isEqualTo(cloudVendor.getVendorName());
	}

	@Test
	void testUpdateCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.updateCloudVendor(cloudVendor, cloudVendor.getVendorId())).isEqualTo("user updated");
	}

	@Test
	void testDeleteCloudVendor() {
		fail("Not yet implemented");
	}

}
