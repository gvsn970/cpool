package com.nexiilabs.cpool.skillset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillSetServiceImpl implements SkillsetService {
	@Autowired
	private SkillSetRepository repository;

	@Override
	public int addSkillSet(SkillSet skillSet) {

		return repository.addSkillSet(skillSet);

	}

	@Override
	public List<SkillSet> listofSkillsets() {
		return repository.listofSkillsets();
	}

}
