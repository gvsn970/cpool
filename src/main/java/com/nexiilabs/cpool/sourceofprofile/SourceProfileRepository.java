package com.nexiilabs.cpool.sourceofprofile;

import java.util.List;

public interface SourceProfileRepository {
	int addSourceProfile(SourceProfile sourceprofile);

	List<SourceProfile> listofSources();

}