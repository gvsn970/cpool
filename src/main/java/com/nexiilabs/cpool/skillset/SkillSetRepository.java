package com.nexiilabs.cpool.skillset;

import java.util.List;

public interface SkillSetRepository {
	

	int addSkillSet(SkillSet skillSet);
	List<SkillSet> listofSkillsets();

}
