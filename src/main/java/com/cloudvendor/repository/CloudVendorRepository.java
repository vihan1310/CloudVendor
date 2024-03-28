package com.cloudvendor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudvendor.entity.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer> {
	 List<CloudVendor> findByVendorName(String vendorName);

}
