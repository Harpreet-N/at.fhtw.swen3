package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.exception.BLParcelException;
import at.fhtw.swen3.services.exception.BLWarehouseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BLParcelException.class, BLWarehouseException.class})
    public ResponseEntity<Error> handleException(Exception exception) {
        String message = "An error occurred!";
        Error error = new Error();
        error.errorMessage(message);
        log.error(exception.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}