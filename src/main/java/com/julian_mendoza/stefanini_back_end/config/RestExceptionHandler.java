package com.julian_mendoza.stefanini_back_end.config;

import com.julian_mendoza.stefanini_back_end.dtos.ErrorDTO;
import com.julian_mendoza.stefanini_back_end.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleExpection(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDTO(ex.getMessage()));
    }
}
