package com.nexiilabs.cpool.currentlocation;

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
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CurrentLocationController {
	@Autowired
	private CurrentLocationService service;

	@RequestMapping(value = "/addcurrentlocations", method = RequestMethod.POST, produces = "application/Json")
	public ResponseEntity<Response> addPrefLoc(@RequestBody CurrentLocation curLocation) {
		Response response = new Response();
		int rowEffected = service.addCurfLoc(curLocation);
		if (rowEffected == 1) {
			response.setStatus(200);
			response.setMessage("current location added");
			response.setDescription("current location added successfuly");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == 2) {
			response.setStatus(400);
			response.setMessage("current location already exist.");
			response.setDescription("current location already exist in Database.");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setStatus(400);
			response.setMessage("try again and empty field found");
			response.setDescription("try again and  all fields are mandatory");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/listcurrentlocations", method = RequestMethod.GET, produces = "application/Json")
	public List<CurrentLocation> listCurLoc() {
		return service.listofCurrentLocation();
	}
}
