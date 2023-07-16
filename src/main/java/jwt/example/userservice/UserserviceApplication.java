package jwt.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        // System.out.println("processing step: " + 1);
        return new BCryptPasswordEncoder();
    }

    //	@Bean
    //	CommandLineRunner run(UserService userService, ProductService productService) {
    //		System.out.println("processing step: " + 6);
    //		return args -> {
    //			userService.saveRole(new Role(null, "ROLE_USER"));
    //			userService.saveRole(new Role(null, "ROLE_MANAGER"));
    //			userService.saveRole(new Role(null, "ROLE_ADMIN"));
    //			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
    //
    //			userService.saveUser(new User(null, "Tung Nguyen", "tung", "1234", new ArrayList<>()));
    //			userService.saveUser(new User(null, "Khanh Tran", "khanh", "1234", new ArrayList<>()));
    //			userService.saveUser(new User(null, "Hoa Pham", "hoa", "1234", new ArrayList<>()));
    //			userService.saveUser(new User(null, "Hiep Nguyen", "admin", "1234", new ArrayList<>()));
    //
    //			userService.addRoleToUser("tung", "ROLE_USER");
    //			userService.addRoleToUser("khanh", "ROLE_MANAGER");
    //			userService.addRoleToUser("khanh", "ROLE_USER");
    //			userService.addRoleToUser("hoa", "ROLE_ADMIN");
    //			userService.addRoleToUser("hoa", "ROLE_MANAGER");
    //			userService.addRoleToUser("hoa", "ROLE_USER");
    //			userService.addRoleToUser("admin", "ROLE_SUPER_ADMIN");
    //			userService.addRoleToUser("admin", "ROLE_ADMIN");
    //			userService.addRoleToUser("admin", "ROLE_MANAGER");
    //			userService.addRoleToUser("admin", "ROLE_USER");
    //
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 2", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 3", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 4", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 5", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 6", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 7", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 8", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 9", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 10", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 11", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 12", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 13", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 14", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 15", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 16", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 17", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 18", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 19", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //			productService.saveProduct(
    //					new Product(null, "Bánh chocopie 20", "Bánh chocopie", 50000.0000, 10, "Bánh kẹo", "Orion", null));
    //		};
    //	}
}
