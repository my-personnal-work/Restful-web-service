package com.in28minutes.rest.webservices.restfulwebservices.versionning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 GetFirstPersonVersionning() {
		return new PersonV1("Ismael Seck");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 GetSecondPersonVersionning() {
		return new PersonV2(new Name("Ismael", "Seck"));
	}
}
