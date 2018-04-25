package com.nexiilabs.cpool.sourceofprofile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class SourceProfileRepositoryImpl implements SourceProfileRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addSourceProfile(SourceProfile sourceprofile) {
		try {
			if (sourceprofile.getSourceofprofile() != null && sourceprofile.getSourceofprofile() != "") {
				boolean isempty = isemptysourceofprofile(sourceprofile.getSourceofprofile());
				if (isempty) {
					entityManager.persist(sourceprofile);
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

	private boolean isemptysourceofprofile(String sourceofprofile) {
		String hql = "SELECT * FROM cpool_sourceof_profile sp where (sp.sourceof_profile='" + sourceofprofile + "')";
		boolean isemptylist = entityManager.createNativeQuery(hql).getResultList().isEmpty();
		if (isemptylist) {
			return true;
		}
		return false;
	}

	@Override
	public List<SourceProfile> listofSources() {
		List<SourceProfile> sourceprofile = new ArrayList<>();
		try {
			String hql = "FROM SourceProfile";
			List sources = entityManager.createQuery(hql).getResultList();
			sourceprofile.addAll(sources);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceprofile;
	}
}