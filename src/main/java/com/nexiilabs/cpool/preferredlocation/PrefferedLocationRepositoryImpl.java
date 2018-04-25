package com.nexiilabs.cpool.preferredlocation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PrefferedLocationRepositoryImpl implements PrefferedLocationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addPrefLoc(PreferredLocation prefferedloc) {
		try {

			if (prefferedloc.getPreferedlocation_name() != null && prefferedloc.getPreferedlocation_name() != "") {
				boolean isExist = isValidPrefLocation(prefferedloc.getPreferedlocation_name());
				if (isExist) {
					entityManager.persist(prefferedloc);
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

	private boolean isValidPrefLocation(String preferedlocation_name) {
		String hql1 = "select * from cpool_preffered_location fs where (fs.preferedlocation_name='"
				+ preferedlocation_name + "')";
		boolean preflocationslist = entityManager.createNativeQuery(hql1).getResultList().isEmpty();
		if (preflocationslist) {
			return true;
		}
		return false;

	}

	@Override
	public List<PreferredLocation> listofPrefferdLocation() {
		List<PreferredLocation> preflocations = new ArrayList<>();
		try {
			String hql = "FROM PreferredLocation";
			List locations = entityManager.createQuery(hql).getResultList();

			preflocations.addAll(locations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preflocations;
	}
}
