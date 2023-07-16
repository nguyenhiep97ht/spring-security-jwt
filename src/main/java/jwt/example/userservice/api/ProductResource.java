package jwt.example.userservice.api;

import jwt.example.userservice.domain.Product;
import jwt.example.userservice.domain.ProductForm;
import jwt.example.userservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Log4j2
public class ProductResource {
  private final ProductService productService;

  @GetMapping("/products")
  public ResponseEntity<Page<Product>> getProducts(@RequestBody ProductForm form) {
    return ResponseEntity.ok().body(productService.getProducts(form));
  }

  @PostMapping("/product/save")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/save").toUriString());
    return ResponseEntity.created(uri).body(productService.saveProduct(product));
  }

}



