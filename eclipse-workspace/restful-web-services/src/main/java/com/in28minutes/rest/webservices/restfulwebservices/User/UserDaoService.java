package com.in28minutes.rest.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Ismael", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Seck", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Ibaka", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteUser(int id) {
		Predicate<? super User> preditcate = user -> user.getId().equals(id);
		users.removeIf(preditcate);
	}

}
