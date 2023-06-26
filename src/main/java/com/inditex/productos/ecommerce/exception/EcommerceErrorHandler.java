package com.inditex.productos.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class EcommerceErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EcommerceError> methodException(HttpServletRequest request, Exception e) {


        EcommerceError errorInfo = new EcommerceError(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

    }

}
