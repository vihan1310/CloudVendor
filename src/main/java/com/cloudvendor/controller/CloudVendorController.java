package com.cloudvendor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudvendor.entity.CloudVendor;
import com.cloudvendor.exception.CloudVendorNotFoundException;
import com.cloudvendor.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
	
	@Autowired
	private CloudVendorService cloudVendorService;
	
	@GetMapping("/getby/{id}")
	public ResponseEntity<CloudVendor> cloudVendorById(@PathVariable("id") Integer id) {
		CloudVendor user= cloudVendorService.getCloudVendorById(id);
		return  ResponseEntity.ok(user); 
		}
	
	@GetMapping("/getAll")
	public List<CloudVendor> cloudVendorAll(){
		return cloudVendorService.getAllCloudVendor();
	}
	 
	@PostMapping("/create")
	public ResponseEntity<Object> createCloudVendor(@RequestBody CloudVendor cloudVendor) {
		try {
		CloudVendor user= cloudVendorService.addCloudVendor(cloudVendor);
		
		return ResponseEntity.ok(user);
		}catch(CloudVendorNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("this id is registerd");
			//return ResponseEntity.badRequest().body("user is already present");
		}
	}
	
	@PutMapping("/update/{id}")
	public String updateCloudVendoreById(@RequestBody CloudVendor cloudVendor ,@PathVariable("id") Integer id) {
		return cloudVendorService.updateCloudVendor(cloudVendor, id);
		}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCloudVendorById(@PathVariable("id") Integer id) {
		cloudVendorService.deleteCloudVendor(id);
		return "delete successfully";
	}

}
