package jwt.example.userservice.service;

import jwt.example.userservice.domain.Product;
import jwt.example.userservice.domain.ProductForm;
import jwt.example.userservice.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
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


