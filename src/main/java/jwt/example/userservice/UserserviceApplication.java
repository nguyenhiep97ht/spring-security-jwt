package jwt.example.userservice;

import jwt.example.userservice.domain.User;
import jwt.example.userservice.domain.Role;
import jwt.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		System.out.println("processing step: " + 1);
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		System.out.println("processing step: " + 6);
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Tung Nguyen", "tung", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Khanh Tran", "khanh", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoa Pham", "hoa", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Hiep Nguyen", "admin", "1234", new ArrayList<>()));

			userService.addRoleToUser("tung", "ROLE_USER");
			userService.addRoleToUser("khanh", "ROLE_MANAGER");
			userService.addRoleToUser("khanh", "ROLE_USER");
			userService.addRoleToUser("hoa", "ROLE_ADMIN");
			userService.addRoleToUser("hoa", "ROLE_MANAGER");
			userService.addRoleToUser("hoa", "ROLE_USER");
			userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("admin", "ROLE_ADMIN");
			userService.addRoleToUser("admin", "ROLE_MANAGER");
			userService.addRoleToUser("admin", "ROLE_USER");
		};
	}

}
