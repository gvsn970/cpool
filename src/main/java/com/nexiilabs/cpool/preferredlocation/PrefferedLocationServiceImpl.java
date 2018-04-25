package com.nexiilabs.cpool.preferredlocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrefferedLocationServiceImpl implements PrefferedLocationService {
	@Autowired
	private PrefferedLocationRepository repository;

	@Override
	public int addPrefLoc(PreferredLocation prefferedloc) {

		return repository.addPrefLoc(prefferedloc);
	}

	@Override
	public List<PreferredLocation> listofPrefferdLocation() {
		return repository.listofPrefferdLocation();
	}
}