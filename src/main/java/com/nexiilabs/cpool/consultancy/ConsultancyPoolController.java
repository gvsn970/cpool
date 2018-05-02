package com.nexiilabs.cpool.consultancy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexiilabs.Response;

@RestController
 @CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ConsultancyPoolController {
	@Autowired
	private ConsultancyService service;

	@RequestMapping(value = "/listofusers", method = RequestMethod.GET, produces = "application/Json")

	public List<ConsultantListResponseDTO> userslist() {
		return service.listofusers();
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/Json")

	public ResponseEntity<Response> addUser(@RequestBody ConsultancyPool consultModel) {
		Response response = new Response();
		int roweffected = service.addUserDetails(consultModel);
		if (roweffected == 1) {
			response.setStatus(200);
			response.setMessage("user details added");
			response.setDescription("user details added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}else if (roweffected == 2) {
			response.setStatus(400);
			response.setMessage("user already exist with this mobile");
			response.setDescription("user already exist with this mobile .choose another mobile");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if (roweffected == 3) {
			response.setStatus(400);
			response.setMessage("user already exist with this email");
			response.setDescription("user already exist with this mail id .choose another mailid");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
		 else {
			response.setStatus(400);
			response.setMessage("try again and empty fields exist");
			response.setDescription("try again and  all fields are mandatory");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/searchlist", method = RequestMethod.POST, produces = "application/Json")
	public List<ConsultantSearchResponseDTO> consultancySearchList(
			@RequestParam("fk_skillset_id") String fk_skillset_id,
			//@RequestParam("fk_experience_id") String fk_experience_id,
			@RequestParam("fk_currentlocation_id") String fk_currentlocation_id,
			@RequestParam("fk_prefered_location_id") String fk_prefered_location_id,
			@RequestParam("notice_period") int notice_period, @RequestParam("min_exp") int min_exp,
			@RequestParam("max_exp") int max_exp, @RequestParam("min_ctc") double min_ctc,
			@RequestParam("max_ctc") double max_ctc) {
		return service.SearchResults(fk_skillset_id, fk_currentlocation_id, fk_prefered_location_id,
				notice_period, min_exp, max_exp, min_ctc, max_ctc);
	}
	@RequestMapping(value="/viewuserbyid",method=RequestMethod.POST,produces="application/Json")
	public List<ConsultantListResponseDTO> consultViewList(@RequestParam("consultant_id") int consultant_id){
		return service.viewuserById(consultant_id);
		 
	}



}
