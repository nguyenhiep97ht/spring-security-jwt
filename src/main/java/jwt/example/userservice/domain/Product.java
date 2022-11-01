package jwt.example.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`product`") // postgreSQL using 'user' as a reserved keyword, so using quote `` to create user tbl success
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private Double price;
  private int amount;
  private String category;
  private String brand;
  private Date createdDate;

}
