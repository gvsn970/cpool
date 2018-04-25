package com.nexiilabs.cpool.sourceofprofile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SourceProfileServiceImpl implements SourceProfileService {
	@Autowired
	private SourceProfileRepository repository;

	@Override
	public int addSourceProfile(SourceProfile sourceprofile) {
		return repository.addSourceProfile(sourceprofile);
	}

	@Override
	public List<SourceProfile> listofSources() {
		return repository.listofSources();
	}
}