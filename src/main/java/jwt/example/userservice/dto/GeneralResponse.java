package jwt.example.userservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class GeneralResponse<T> {
  private HttpStatus code;
  private String msg;
  private T data;
}