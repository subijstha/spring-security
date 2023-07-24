package com.truth.security;

import com.truth.security.model.Users;
import com.truth.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users user = new Users();
		user.setEmail("john@gmail.com");
		user.setUsername("john");
		user.setPassword(this.bCryptPasswordEncoder.encode("123"));
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);

		Users user1 = new Users();
		user1.setEmail("truth@gmail.com");
		user1.setUsername("truth");
		user1.setPassword(this.bCryptPasswordEncoder.encode("123"));
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
	}

}
