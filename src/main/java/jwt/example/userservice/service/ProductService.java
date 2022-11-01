package jwt.example.userservice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import jwt.example.userservice.domain.Product;
import jwt.example.userservice.domain.ProductForm;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProduct(Long id);
    Page<Product> getProducts(ProductForm productForm);
}
