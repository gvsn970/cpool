package com.nexiilabs.cpool.consultancy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultancyServiceImpl implements ConsultancyService {
	@Autowired
	private ConsultancyPoolRepository repository;

	@Override
	public int addUserDetails(ConsultancyPool consultdto) {

		return repository.addUserDetails(consultdto);

	}

	@Override
	public List<ConsultantListResponseDTO> listofusers() {

		return repository.listofusers();
	}

	@Override
	public List<ConsultantSearchResponseDTO> SearchResults(String fk_skillset_id, String fk_experience_id,
			String fk_currentlocation_id, String fk_prefered_location_id, int notice_period, String min_exp,
			String max_exp, double min_ctc, double max_ctc) {

		return repository.SearchResults(fk_skillset_id, fk_experience_id, fk_currentlocation_id, fk_prefered_location_id,
				notice_period, min_exp, max_exp, min_ctc, max_ctc);
	}
	@Override
	public List<ConsultantListResponseDTO> viewuserById(int consultant_id) {
		
		return repository.viewuserById(consultant_id);
	}

}
