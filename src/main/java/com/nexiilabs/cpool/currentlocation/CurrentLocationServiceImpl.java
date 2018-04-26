package com.nexiilabs.cpool.currentlocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentLocationServiceImpl implements CurrentLocationService{
	@Autowired
	private CurrentLocationRepository repository;

	@Override
	public int addCurfLoc(CurrentLocation curLocation) {
		
		return repository.addCurfLoc(curLocation);
	}

	@Override
	public List<CurrentLocation> listofCurrentLocation() {
		return repository.listofCurrentLocation();
	}
}

