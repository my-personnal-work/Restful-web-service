package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Ismael", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Seck", LocalDate.now().minusYears(25)));
		users.add(new User(3, "Ibaka", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}

}
