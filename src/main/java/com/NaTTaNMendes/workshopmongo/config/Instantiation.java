package com.NaTTaNMendes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.NaTTaNMendes.workshopmongo.domain.Post;
import com.NaTTaNMendes.workshopmongo.domain.User;
import com.NaTTaNMendes.workshopmongo.repository.PostRepository;
import com.NaTTaNMendes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//Deleting all users that are in the database
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//Instantiating new users for the tests
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//Sending users to database
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		//Creating posts
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);
		
		//Saving posts
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
	
}
