package mx.uv.coatza.eShop.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validationErrors() {
        return null;
    }
}
