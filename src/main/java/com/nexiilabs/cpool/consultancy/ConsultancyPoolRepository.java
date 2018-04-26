package com.nexiilabs.cpool.consultancy;

import java.util.List;

public interface ConsultancyPoolRepository {
	int addUserDetails(ConsultancyPool consultdto);

	List<ConsultantListResponseDTO> listofusers();


	List<ConsultantSearchResponseDTO> SearchResults(String fk_skillset_id, String fk_experience_id, String fk_currentlocation_id,
			String fk_prefered_location_id, int notice_period, String min_exp, String max_exp, double min_ctc,
			double max_ctc);
	List<ConsultantListResponseDTO> viewuserById(int consultant_id);
}
