package jwt.example.userservice.domain;

import lombok.Data;

@Data
public class ProductForm {
  private int limit;
  private int offset;
}
