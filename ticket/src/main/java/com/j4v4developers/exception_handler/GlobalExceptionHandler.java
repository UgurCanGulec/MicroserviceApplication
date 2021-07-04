package com.j4v4developers.exception_handler;

import com.j4v4developers.exception.TicketNotFoundException;
import com.j4v4developers.exception.TicketProcessCouldNotRunException;
import com.j4v4developers.enumaration.ErrorType;
import com.j4v4developers.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        body.put("errors", errors);
        errors.forEach(log::error);
        return new ResponseEntity<>(new BaseResponse<>(null, ErrorType.BAD_REQUEST.name(), body, false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TicketProcessCouldNotRunException.class})
    public ResponseEntity<Object> handleAuthorNotFoundException(TicketProcessCouldNotRunException ex, WebRequest webRequest) {
        Map<String ,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message", "Ticket process failed !");
        body.put("error message", ex.getMessage());
        log.error("Ticket process failed !");
        return new ResponseEntity<>(new BaseResponse<>(null, ErrorType.BAD_REQUEST.name(), body,false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({TicketNotFoundException.class})
    public ResponseEntity<Object> handleAuthorNotFoundException(TicketNotFoundException ex, WebRequest webRequest) {
        Map<String ,Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("message", "Ticket not found !");
        body.put("error message", ex.getMessage());
        log.error("Ticket not found !");
        return new ResponseEntity<>(new BaseResponse<>(null, ErrorType.NOT_FOUND.name(), body,false), HttpStatus.NOT_FOUND);
    }

}
