package jwt.example.userservice.api;

import jwt.example.userservice.dto.GeneralResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.method.HandlerMethod;

@Log4j2
@RestControllerAdvice(basePackages = {"jwt.example.userservice.api"})
public class BaseResourceAdvice {

    @Getter
    @Setter(onMethod = @__({@Lazy, @Autowired}))
    private MessageSource messageSource;

    private static final String ERROR_MESSAGE_FORMAT = "Error occur when {} [{}]";

    private static final String END_WITH_ERROR_LOG_PATTERN = "===== End {} Error =====";

    @ExceptionHandler({HttpServerErrorException.class, HttpClientErrorException.class})
    @ResponseBody
    public Object handleBadRequestAPIError(
            HttpStatusCodeException exception, HandlerMethod handlerMethod) {
        String methodName = handlerMethod.getMethod().getName();

        String err = exception.getResponseBodyAsString();
        log.error(ERROR_MESSAGE_FORMAT, methodName, exception.getMessage() + " " + err);

        log.info(END_WITH_ERROR_LOG_PATTERN, methodName);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(GeneralResponse
                        .builder()
                        .msg(err)
                        .code(HttpStatus.BAD_REQUEST)
                        .data(null)
                        .build());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public Object handleAPIError(AccessDeniedException exception, HandlerMethod handlerMethod) {
        String methodName = handlerMethod.getMethod().getName();

        String err = exception.getMessage();
        log.error(ERROR_MESSAGE_FORMAT, methodName, exception.getMessage() + " " + err);

        log.info(END_WITH_ERROR_LOG_PATTERN, methodName);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(GeneralResponse
                        .builder()
                        .msg(err)
                        .code(HttpStatus.FORBIDDEN)
                        .data(null)
                        .build());
    }

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public Object handleAPIError(
            ServletRequestBindingException exception, HandlerMethod handlerMethod) {
        String methodName = handlerMethod.getMethod().getName();

        String err = exception.getMessage();
        log.error(ERROR_MESSAGE_FORMAT, methodName, exception.getMessage() + " " + err);

        log.info(END_WITH_ERROR_LOG_PATTERN, methodName);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GeneralResponse
                        .builder()
                        .msg(err)
                        .code(HttpStatus.INTERNAL_SERVER_ERROR)
                        .data(null)
                        .build());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object handleAPIError(Throwable exception, HandlerMethod handlerMethod) {
        String methodName = handlerMethod.getMethod().getName();

        String err = exception.getMessage();
        log.error(ERROR_MESSAGE_FORMAT, methodName, exception.getMessage() + " " + err);

        log.info(END_WITH_ERROR_LOG_PATTERN, methodName);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GeneralResponse
                        .builder()
                        .msg(err)
                        .code(HttpStatus.INTERNAL_SERVER_ERROR)
                        .data(null)
                        .build());
    }

}
