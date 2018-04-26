package com.nexiilabs.cpool.currentlocation;

import java.util.List;

public interface CurrentLocationRepository {
	int addCurfLoc(CurrentLocation curLocation);
	List<CurrentLocation> listofCurrentLocation();

}
