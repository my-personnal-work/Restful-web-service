package com.in28minutes.rest.webservices.restfulwebservices.versionning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	//URI Versionning 
	@GetMapping("/v1/person")
	public PersonV1 GetFirstPersonVersionning() {
		return new PersonV1("Ismael Seck");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 GetSecondPersonVersionning() {
		return new PersonV2(new Name("Ismael", "Seck"));
	}
	
	//Params Versionning
	@GetMapping(path="/person", params="version=1")
	public PersonV1 GetFirstPersonVersionningRequestParameter() {
		return new PersonV1("Ismael Seck");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 GetSecondPersonVersionningRequestParameter() {
		return new PersonV2(new Name("Ismael", "Seck"));
	}
	
	//Header Versionning 
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 GetFirstPersonVersionningRequestHeader() {
		return new PersonV1("Ismael Seck");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 GetSecondPersonVersionningRequestHeader() {
		return new PersonV2(new Name("Ismael", "Seck"));
	}
	
	//Media Type versionning Or Content Negociation
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 GetFirstPersonVersionningAcceptHeader() {
		return new PersonV1("Ismael Seck");
	}
	
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 GetSecondPersonVersionningAcceptHeader() {
		return new PersonV2(new Name("Ismael", "Seck"));
	}
	
}
