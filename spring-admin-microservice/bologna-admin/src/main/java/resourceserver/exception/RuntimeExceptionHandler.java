package resourceserver.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import resourceserver.apierror.ApiValidationError;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RuntimeExceptionHandler{
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException exception){
        ApiValidationError error = new ApiValidationError();
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(error);
    }
}
