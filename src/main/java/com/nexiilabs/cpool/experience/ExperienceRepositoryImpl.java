package com.nexiilabs.cpool.experience;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ExperienceRepositoryImpl implements ExperienceRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addExperience(Experience experience) {
		try {
			if (experience.getExperience() != null && experience.getExperience() !="") {
				boolean isExist = isExperience(experience.getExperience());
				if (isExist) {
					entityManager.persist(experience);
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

	public boolean isExperience(String experience) {
		String query = "SELECT * FROM cpool_experience fs where (fs.experience='" + experience + "')";
		boolean experiencelist = entityManager.createNativeQuery(query).getResultList().isEmpty();
		if (experiencelist) {
			return true;
		}
		return false;
	}

	@Override
	public List<Experience> listofExperience() {

		List<Experience> experience = new ArrayList<>();
		try {
			String query = "FROM Experience";
			List experienceList = entityManager.createQuery(query).getResultList();

			experience.addAll(experienceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return experience;
	}

}
