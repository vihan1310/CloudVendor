package com.cloudvendor.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
public class CloudVendor {
	
	@jakarta.persistence.Id
	
	private Integer vendorId;
	
	@NotEmpty(message = "Name should not be empty")
	@Size(max = 20, message = "size must not exceed 20 letters,")
	private String vendorName;
	
	@NotEmpty(message="Address should not be empty")
	private String vendorAddress;
	
	@NotEmpty(message="PhoneNumber shouled not be empty")
	@Size(min = 10, max = 10, message = "Phone number must have 10 digits only")
	private String vendorPhoneNumber;

	public CloudVendor(Integer vendorId,
			@NotEmpty(message = "Name should not be empty") @Size(max = 20, message = "size must not exceed 20 letters,") String vendorName,
			@NotEmpty(message = "Address should not be empty") String vendorAddress,
			@NotEmpty(message = "PhoneNumber shouled not be empty") @Size(min = 10, max = 10, message = "Phone number must have 10 digits only") String vendorPhoneNumber) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}

	public CloudVendor() {
		super();
	}
	

}
