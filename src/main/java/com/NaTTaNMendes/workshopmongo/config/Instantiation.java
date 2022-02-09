package com.NaTTaNMendes.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.NaTTaNMendes.workshopmongo.domain.User;
import com.NaTTaNMendes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Deleting all users that are in the database
		userRepository.deleteAll();
		
		//Instantiating new users for the tests
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Sending users to database
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
	
}
