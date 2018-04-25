package com.nexiilabs.cpool.sourceofprofile;

import java.util.List;

public interface SourceProfileService {
	int addSourceProfile(SourceProfile sourceprofile);

	List<SourceProfile> listofSources();
}