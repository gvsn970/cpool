package com.nexiilabs.cpool.experience;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nexiilabs.Response;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ExperienceController {
	@Autowired
	private ExperienceService service;
	@RequestMapping(value = "/addexperience", method = RequestMethod.POST, produces = "application/Json")
	public ResponseEntity<Response> addExperience(@RequestBody Experience experience) {
		Response response = new Response();
		int rowEffected = service.addExperience(experience);
		if (rowEffected ==1) {
			response.setStatus(200);
			response.setMessage("Experience added");
			response.setDescription("Experience added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} 
		else if(rowEffected==2) {
			response.setStatus(400);
			response.setMessage(" already exist Experience name");
			response.setDescription(" already exist  this Experience name .choose another Experience name");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}else {
			response.setStatus(400);
			response.setMessage("try again and empty field found");
			response.setDescription("try again and all fields are mandatory");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/listexperience", method = RequestMethod.GET, produces = "application/Json")
	public List<Experience> listExperience() {
		return service.listofExperience();
	}
}
