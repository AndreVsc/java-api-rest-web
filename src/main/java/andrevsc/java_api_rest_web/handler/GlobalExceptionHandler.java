package andrevsc.java_api_rest_web.handler;

import jakarta.annotation.Resource;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleBusinessException(Exception e, @NonNull WebRequest request) {
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            return new ResponseEntity<>(responseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR), headers(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, request.getLocale());
            return new ResponseEntity<>(responseError(message, HttpStatus.BAD_REQUEST), headers(), HttpStatus.BAD_REQUEST);
        }
    }
}