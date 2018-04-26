package com.nexiilabs.cpool.currentlocation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Transactional
@Repository
public class CurrentLocationRepositoryImpl implements CurrentLocationRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addCurfLoc(CurrentLocation curLocation) {
		try {

			if (curLocation.getCurrentlocation_name() != null && curLocation.getCurrentlocation_name() != "") {
				boolean isExist = isValidCurrLocation(curLocation.getCurrentlocation_name());
				if (isExist) {
					entityManager.persist(curLocation);
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
	private boolean isValidCurrLocation(String currentlocation_name) {
		String hql1 = "select * from cpool_current_location cl where (cl.currentlocation_name='"
				+ currentlocation_name + "')";
		boolean currlocationslist = entityManager.createNativeQuery(hql1).getResultList().isEmpty();
		if (currlocationslist) {
			return true;
		}
		return false;

	}
	@Override
	public List<CurrentLocation> listofCurrentLocation() {
		List<CurrentLocation> currlocations = new ArrayList<>();
		try {
			String hql = "FROM CurrentLocation";
			List locations = entityManager.createQuery(hql).getResultList();

			currlocations.addAll(locations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currlocations;
	}
	}


