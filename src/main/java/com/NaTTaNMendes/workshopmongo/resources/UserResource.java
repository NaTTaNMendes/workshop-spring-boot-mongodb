package com.NaTTaNMendes.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NaTTaNMendes.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User nattan = new User("1", "Nattan", "nattan@gmail.com");
		User andre = new User("2", "André", "andre@gmail.com");
		User pedro = new User("3", "Pedro", "pedro@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(nattan, andre, pedro));
		return ResponseEntity.ok().body(list);
	}
}
