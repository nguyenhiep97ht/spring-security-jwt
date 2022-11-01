package jwt.example.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import jwt.example.userservice.domain.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    
}
