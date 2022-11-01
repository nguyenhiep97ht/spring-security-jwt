package jwt.example.userservice.service;

import java.util.List;

import jwt.example.userservice.domain.Product;
import jwt.example.userservice.domain.ProductForm;
import jwt.example.userservice.repo.ProductRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        // TODO Auto-generated method stub
        log.info("saving new product {} to the database", product.getName());
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Long id) {
        // TODO Auto-generated method stub
        log.info("fetching product {}", id);
        return productRepo.getById(id);
    }

    @Override
    public Page<Product> getProducts(ProductForm productForm) {
        // TODO Auto-generated method stub
        log.info("fetching all products");
        return productRepo.findAll(PageRequest.of(productForm.getOffset(), productForm.getLimit(), Sort.by("name").descending()));
    }

}


