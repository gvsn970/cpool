package com.nexiilabs.cpool.sourceofprofile;

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
public class SourceProfileController {
	@Autowired
	private SourceProfileService service;

	@RequestMapping(value = "/addsourceofprofile", method = RequestMethod.POST, produces = "application/Json")
	public ResponseEntity<Response> addSourceofProfile(@RequestBody SourceProfile sourceprofile) {
		Response response = new Response();
		int roweffected = service.addSourceProfile(sourceprofile);
		if (roweffected == 1) {
			response.setStatus(200);
			response.setMessage("source of profile added successfully");
			response.setDescription("source of profile added successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);

		} else if (roweffected == 2) {
			response.setStatus(400);
			response.setMessage("source of profile is already exist");
			response.setDescription("source of profile is already exist in database");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

		} else {
			response.setStatus(400);
			response.setMessage("try again and  fields are mandatory");
			response.setDescription("try again and  fields are mandatory");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/listofsourceprofiles", method = RequestMethod.GET, produces = "application/Json")
	public List<SourceProfile> listSources() {
		return service.listofSources();

	}

}
