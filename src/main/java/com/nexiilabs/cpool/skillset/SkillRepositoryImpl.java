package com.nexiilabs.cpool.skillset;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class SkillRepositoryImpl implements SkillSetRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addSkillSet(SkillSet skillSet) {

		try {

			
			if (skillSet.getSkillset_name() != null && skillSet.getSkillset_name() !="") {

				boolean isValid = isValidSkillSet(skillSet.getSkillset_name());
				if (isValid) {
					entityManager.persist(skillSet);
					return 1;
				} else {
					return 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean isValidSkillSet(String skillset_name) {
		String hql1 = "SELECT * FROM cpool_skill_set fs where (fs.skillset_name='" + skillset_name + "')";
		boolean skillist = entityManager.createNativeQuery(hql1).getResultList().isEmpty();
		if (skillist) {
			return true;
		}
		return false;
	}

	@Override
	public List<SkillSet> listofSkillsets() {
		List<SkillSet> skillsets = new ArrayList<>();
		try {
			String hql = "FROM SkillSet";
			List skills = entityManager.createQuery(hql).getResultList();

			skillsets.addAll(skills);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return skillsets;
	}

}
