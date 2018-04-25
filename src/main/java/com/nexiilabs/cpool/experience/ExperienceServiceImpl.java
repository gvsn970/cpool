package com.nexiilabs.cpool.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements ExperienceService {
	@Autowired
	private ExperienceRepository experienceRepository;

	@Override
	public int addExperience(Experience experience) {
		
		return experienceRepository.addExperience(experience);
	}

	@Override
	public List<Experience> listofExperience() {
		// TODO Auto-generated method stub
		return experienceRepository.listofExperience();
	}

}
