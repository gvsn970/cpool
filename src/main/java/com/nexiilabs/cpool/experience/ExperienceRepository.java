package com.nexiilabs.cpool.experience;

import java.util.List;

public interface ExperienceRepository {

	int addExperience(Experience experience);

	List<Experience> listofExperience();
}
