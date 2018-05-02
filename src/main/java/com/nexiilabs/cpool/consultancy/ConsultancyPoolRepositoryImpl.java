package com.nexiilabs.cpool.consultancy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class ConsultancyPoolRepositoryImpl implements ConsultancyPoolRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public int addUserDetails(ConsultancyPool consultdto) {
		try {

			if (consultdto.getFname() != null && consultdto.getLname() != null) {
				consultdto.setFk_skillset_id(consultdto.getFk_skillset_id().replaceFirst(",",""));
				consultdto.setFk_prefered_location_id(consultdto.getFk_prefered_location_id().replaceFirst(",",""));
				boolean isEmailExist = isValidEmail(consultdto.getEmail());
				boolean ismobileExist = isValidMobile(consultdto.getMobile());
				if (isEmailExist) {
					if(ismobileExist )
					{
						consultdto.setName(consultdto.getFname() + " " + consultdto.getLname());
						entityManager.persist(consultdto);
						return 1;
						
					}else {
						return 2;
					}
				} else {
					return 3;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public boolean isValidEmail(String email) {
		String hql1 = "select * from cpool_consultant cpl where (cpl.email='" + email + "') and cpl.delete_status=0";
		boolean userlist = entityManager.createNativeQuery(hql1).getResultList().isEmpty();
		if (userlist) {
			return true;
		}
		return false;
	}
	public boolean isValidMobile(String mobile) {
		String query = "select * from cpool_consultant cpl where (cpl.mobile='" + mobile + "') and cpl.delete_status=0";
		boolean usermobile = entityManager.createNativeQuery(query).getResultList().isEmpty();
		if (usermobile) {
			return true;
		}
		return false;
	}

	@Override
	public List<ConsultantListResponseDTO> listofusers() {
		List<ConsultantListResponseDTO> consultacylist = new ArrayList<ConsultantListResponseDTO>();
		try {
			String query = "SELECT cpl.consultant_id,cpl.name,cpl.email,cpl.mobile,cpl.fname,cpl.lname,cpl.current_ctc," + 
					"exp.experience,sp.sourceof_profile,GROUP_CONCAT(DISTINCT ss.skillset_name),GROUP_CONCAT(DISTINCT pfd.preferedlocation_name)," + 
					"cl.currentlocation_name,cpl.notice_period,cpl.education,cpl.current_designation,cpl.current_organization,cpl.previous_organization,DATEDIFF(CURDATE(),cpl.created_on) " + 
					"AS days FROM cpool_consultant cpl JOIN cpool_current_location cl ON cl.currentlocation_id=cpl.fk_currentlocation_id " + 
					"JOIN cpool_sourceof_profile sp ON cpl.fk_sourceof_profile_id=sp.sourceof_profile_id JOIN " + 
					"cpool_experience exp ON cpl.fk_experience_id=exp.experience_id,cpool_preffered_location pfd,cpool_skill_set ss where cpl.delete_status=0 AND " + 
					"FIND_IN_SET(ss.skillset_id,cpl.fk_skillset_id) AND FIND_IN_SET(pfd.prefered_location_id,cpl.fk_prefered_location_id) " + 
					"GROUP BY cpl.consultant_id;";
			ConsultantListResponseDTO consultancyPool=null;
			List<Object> list = entityManager.createNativeQuery(query).getResultList();
		
			if (!list.isEmpty()) {
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					consultancyPool = new ConsultantListResponseDTO();
					consultancyPool.setConsultant_id(Integer.parseInt(String.valueOf(obj[0])));
					consultancyPool.setName(String.valueOf(obj[1]));
					consultancyPool.setEmail(String.valueOf(obj[2]));
					consultancyPool.setMobile(String.valueOf(obj[3]));
					consultancyPool.setFname(String.valueOf(obj[4]));
					consultancyPool.setLname(String.valueOf(obj[5]));
					consultancyPool.setCurrent_ctc(Double.parseDouble(String.valueOf(obj[6])));
					consultancyPool.setExperience(String.valueOf(obj[7]));
					consultancyPool.setSourceofprofile(String.valueOf(obj[8]));
					consultancyPool.setSkillset_name(String.valueOf(obj[9]));
					consultancyPool.setPreferedlocation_name(String.valueOf(obj[10]));
					consultancyPool.setCurrent_location(String.valueOf(obj[11]));
					consultancyPool.setNotice_period(Integer.parseInt(String.valueOf(obj[12])));
					consultancyPool.setEducation(String.valueOf(obj[13]));
					consultancyPool.setCurrent_designation(String.valueOf(obj[14]));
					consultancyPool.setCurrent_organization(String.valueOf(obj[15]));
					consultancyPool.setPrevious_organization(String.valueOf(obj[16]));
					consultancyPool.setDays(String.valueOf(obj[17]));
					
					consultacylist.add(consultancyPool);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultacylist;
	}

	@Override
	public List<ConsultantSearchResponseDTO> SearchResults(String fk_skillset_id ,String fk_currentlocation_id,String fk_prefered_location_id, int notice_period, int min_exp, int max_exp, double min_ctc,double max_ctc) {
		List<ConsultantSearchResponseDTO> searchlist = new ArrayList<ConsultantSearchResponseDTO>();
		try {


			String query="select  cpl.consultant_id,cpl.name,cpl.email,cpl.mobile,cpl.fname,cpl.lname,cpl.current_ctc," + 
					"exp.experience,sp.sourceof_profile,GROUP_CONCAT(DISTINCT ss.skillset_name)," + 
					" GROUP_CONCAT(DISTINCT pl.preferedlocation_name),cpl.notice_period," + 
					"cl.currentlocation_name,cpl.education,cpl.current_designation,cpl.current_organization," + 
					"cpl.previous_organization," + 
					"DATEDIFF(CURDATE(),cpl.created_on) AS days FROM cpool_consultant cpl JOIN cpool_current_location cl ON cl.currentlocation_id=cpl.fk_currentlocation_id JOIN  cpool_experience exp ON " + 
					"exp.experience_id=cpl.fk_experience_id JOIN cpool_sourceof_profile sp ON " + 
					"sp.sourceof_profile_id=cpl.fk_sourceof_profile_id,cpool_skill_set ss,cpool_preffered_location pl WHERE   cpl.delete_status=0 " + 
					"AND FIND_IN_SET(ss.skillset_id,cpl.fk_skillset_id) AND cpl.fk_skillset_id " + 
					"LIKE '%"+fk_skillset_id+"%' AND  FIND_IN_SET(pl.prefered_location_id,cpl.fk_prefered_location_id) AND " + 
					"cpl.fk_prefered_location_id LIKE '%"+fk_prefered_location_id+"%' AND " + 
					"cpl.fk_currentlocation_id LIKE '%"+fk_currentlocation_id+"' AND cpl.fk_experience_id BETWEEN '"+min_exp+"' AND '"+max_exp+"' AND " + 
					"cpl.notice_period <= '"+notice_period+"' AND   cpl.current_ctc " + 
					" BETWEEN '"+min_ctc+"' AND '"+max_ctc+"'  GROUP BY cpl.consultant_id;";
			ConsultantSearchResponseDTO consultancyPool = null;
			
			List<Object> list = entityManager.createNativeQuery(query).getResultList();
			if (!list.isEmpty()) {
				Iterator iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					consultancyPool = new ConsultantSearchResponseDTO();
					consultancyPool.setConsultant_id(Integer.parseInt(String.valueOf(obj[0])));
					consultancyPool.setName(String.valueOf(obj[1]));
					consultancyPool.setEmail(String.valueOf(obj[2]));
					consultancyPool.setMobile(String.valueOf(obj[3]));
					consultancyPool.setFname(String.valueOf(obj[4]));
					consultancyPool.setLname(String.valueOf(obj[5]));
					consultancyPool.setCurrent_ctc(Double.parseDouble(String.valueOf(obj[6])));
					consultancyPool.setExperience(String.valueOf(obj[7]));
					consultancyPool.setSourceofprofile(String.valueOf(obj[8]));
					consultancyPool.setSkillset_name(String.valueOf(obj[9]));
					consultancyPool.setPreferedlocation_name(String.valueOf(obj[10]));
					
					consultancyPool.setNotice_period(Integer.parseInt(String.valueOf(obj[11])));
					consultancyPool.setCurrent_location(String.valueOf(obj[12]));
					consultancyPool.setEducation(String.valueOf(obj[13]));
					consultancyPool.setCurrent_designation(String.valueOf(obj[14]));
					consultancyPool.setCurrent_organization(String.valueOf(obj[15]));
					consultancyPool.setPrevious_organization(String.valueOf(obj[16]));
					consultancyPool.setDays(String.valueOf(obj[17]));

					searchlist.add(consultancyPool);
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchlist;
	}
	
	@Override
    public List<ConsultantListResponseDTO> viewuserById(int consultant_id) {
            
            List<ConsultantListResponseDTO> userlist=new ArrayList<ConsultantListResponseDTO>();
            try {
      
                    String query="SELECT cpl.consultant_id,cpl.name,cpl.email,cpl.mobile,cpl.fname,cpl.lname,cpl.current_ctc," + 
                    		"exp.experience,sp.sourceof_profile,GROUP_CONCAT(DISTINCT ss.skillset_name)," + 
                    		"GROUP_CONCAT(DISTINCT pfd.preferedlocation_name),cl.currentlocation_name,cpl.notice_period,DATEDIFF(CURDATE(),cpl.created_on)AS days,cpl.education,cpl.current_designation,cpl.current_organization,cpl.previous_organization" + 
                    		" FROM cpool_consultant cpl JOIN cpool_current_location cl ON cl.currentlocation_id=cpl.fk_currentlocation_id " + 
                    		"JOIN cpool_sourceof_profile sp ON cpl.fk_sourceof_profile_id=sp.sourceof_profile_id JOIN " + 
                    		"cpool_experience exp ON cpl.fk_experience_id=exp.experience_id,cpool_skill_set ss," + 
                    		"cpool_preffered_location pfd " + 
                    		"where cpl.delete_status=0 AND cpl.consultant_id='"+consultant_id+"' AND " + 
                    		"FIND_IN_SET(ss.skillset_id,cpl.fk_skillset_id) AND " + 
                    		"find_in_set(pfd.prefered_location_id,cpl.fk_prefered_location_id) " + 
                    		"GROUP BY cpl.consultant_id";
                    ConsultantListResponseDTO consultancyPool=null;
                    List<Object> list = entityManager.createNativeQuery(query).getResultList();
                    if (!list.isEmpty()) {
                            Iterator iterator = list.iterator();
                            while (iterator.hasNext()) {
                                    Object[] obj = (Object[]) iterator.next();
                                    consultancyPool = new ConsultantListResponseDTO();
                                    consultancyPool.setConsultant_id(Integer.parseInt(String.valueOf(obj[0])));
                                    consultancyPool.setName(String.valueOf(obj[1]));
                                    consultancyPool.setEmail(String.valueOf(obj[2]));
                                    consultancyPool.setMobile(String.valueOf(obj[3]));
                                    consultancyPool.setFname(String.valueOf(obj[4]));
                                    consultancyPool.setLname(String.valueOf(obj[5]));
                                    consultancyPool.setCurrent_ctc(Double.parseDouble(String.valueOf(obj[6])));
                                    consultancyPool.setExperience(String.valueOf(obj[7]));
                                    consultancyPool.setSourceofprofile(String.valueOf(obj[8]));
                                    consultancyPool.setSkillset_name(String.valueOf(obj[9]));
                                    consultancyPool.setPreferedlocation_name(String.valueOf(obj[10]));
                                    consultancyPool.setCurrent_location(String.valueOf(obj[11]));
                                    consultancyPool.setNotice_period(Integer.parseInt(String.valueOf(obj[12])));
                                    consultancyPool.setDays(String.valueOf(obj[13]));
                                    consultancyPool.setEducation(String.valueOf(obj[14]));
                                    consultancyPool.setPrevious_organization(String.valueOf(obj[15]));
                                    consultancyPool.setCurrent_organization(String.valueOf(obj[16]));
                                    consultancyPool.setCurrent_designation(String.valueOf(obj[17]));
                                    userlist.add(consultancyPool);
                            }
                    }
            } catch (Exception e) {
                    e.printStackTrace();
            }
            return userlist;
            
    }


}
