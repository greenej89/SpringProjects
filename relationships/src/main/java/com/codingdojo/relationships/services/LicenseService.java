package com.codingdojo.relationships.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository){
		this.licenseRepository = licenseRepository;
	}
	
	//finds a person by id
	public License findLicenseById(Long licenseId) {
		return licenseRepository.findById(licenseId).orElse(null);
	}
	
    // creates a license
    public License createLicense(License license) {
    	return licenseRepository.save(license);
    }
    
    //updates license
	public void updateLicense(License license) {
		licenseRepository.save(license);
	}
	
	//returns all the licenses
	public ArrayList<License> getAllLicenses() {
		return licenseRepository.findAll();
	}
	
	//find last license in database
	public License findLastLicense() {
		return licenseRepository.findTopByOrderByIdDesc();
	}
	
	public String getNextLicenseId() {
		License lastLicense = findLastLicense();
		if(lastLicense == null) {
			return String.format("%08d", 1);
		} else {
			return String.format("%08d", lastLicense.getId() + 1);
		}
	}
}
