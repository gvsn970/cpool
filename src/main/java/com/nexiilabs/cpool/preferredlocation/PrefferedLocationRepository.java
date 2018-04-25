package com.nexiilabs.cpool.preferredlocation;

import java.util.List;

public interface PrefferedLocationRepository {
	int addPrefLoc(PreferredLocation prefferedloc);

	List<PreferredLocation> listofPrefferdLocation();
}
