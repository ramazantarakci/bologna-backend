package resourceserver.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import resourceserver.apierror.ApiError;
import resourceserver.exception.RestExceptionHandler;

//@Controller
//public class CustomErrorController implements ErrorController {
//    @RequestMapping("/error")
//    public ResponseEntity<Object> handleError(Exception ex) {
//        RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//        apiError.setMessage("URL OR REQUEST BODY IS MAY BE WRONG PLEASE CHECK IT "+ex.getMessage());
//        return restExceptionHandler.buildResponseEntity(apiError);
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}