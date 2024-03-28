package com.cloudvendor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cloudvendor.entity.CloudVendor;

@DataJpaTest
public class CloudVendorRepositoryTest {
	
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	CloudVendor cloudVendor;
	
	@BeforeEach
    public void setUp() {
		cloudVendor =new CloudVendor(12,"goggle","usa","5467789432");
		cloudVendorRepository.save(cloudVendor);
		
       
    }
    @AfterEach
    public void tearDown() {
    	cloudVendor = null;
    	cloudVendorRepository.deleteAll();
        
    }
    
    @Test
    void testFindByVendorNameFound() {
    	List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("goggle");
    	assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
    	assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    	assertThat(cloudVendorList.get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());
    	
    }
    
    @Test
    void testFindByVendorNameNotFound() {
    	List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("amazon");
    	assertThat(cloudVendorList.isEmpty()).isTrue();
    	
    }
	

}
