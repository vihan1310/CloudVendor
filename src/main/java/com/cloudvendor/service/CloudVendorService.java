package com.cloudvendor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudvendor.entity.CloudVendor;
import com.cloudvendor.exception.CloudVendorNotFoundException;
import com.cloudvendor.repository.CloudVendorRepository;

@Service
public class CloudVendorService {
	
	@Autowired
	private CloudVendorRepository cloudVendorRepository;
	

	public CloudVendorService(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	public CloudVendor getCloudVendorById(Integer id) {
		return cloudVendorRepository.findById(id).orElseThrow(() -> 
		new CloudVendorNotFoundException("no user found with this id"));
		}
		
	public List<CloudVendor> getAllCloudVendor(){
		return cloudVendorRepository.findAll();
	}
	
	public CloudVendor addCloudVendor( CloudVendor cloudVendor) throws CloudVendorNotFoundException { 
		if(cloudVendorRepository.existsById(cloudVendor.getVendorId())) {
			throw new CloudVendorNotFoundException("user with this id is already registered");
		}
		else {
			return cloudVendorRepository.save(cloudVendor);
			//return "user added successfully";
		}
			 }
		
		
	
	public String updateCloudVendor(CloudVendor cloudVendor,Integer id) {
		
		CloudVendor user= cloudVendorRepository.findById(id).orElseThrow(() 
				-> new CloudVendorNotFoundException("no user is not found with given id"));
		
			user.setVendorName(cloudVendor.getVendorName());
			user.setVendorAddress(cloudVendor.getVendorAddress());
			user.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
			cloudVendorRepository.save(user);
			return "user updated";
			
		
		}
	
	public String deleteCloudVendor(Integer id) {
		cloudVendorRepository.findById(id).orElseThrow(() 
				-> new CloudVendorNotFoundException("Cant delete as no user is registered with given id"));
		cloudVendorRepository.deleteById(id);
		return "deleted";
		
	}
	
	
	

}
