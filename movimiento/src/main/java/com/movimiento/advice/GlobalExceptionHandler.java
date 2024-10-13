package com.movimiento.advice;

import com.movimiento.errors.ApiErrors;
import com.movimiento.exception.BussinesException;
import com.movimiento.exception.idNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("MediaType no soportado");
        detalles.add(ex.getMessage());
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);

    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Formatos no coinciden");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Variable de URL no encontrada");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Parámetro de peticion no encontrado");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("Verbo HTTP no soportado por el método");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> detalles = new ArrayList<String>();
        detalles.add("RequestBody is not readable");
        ApiErrors errores = new ApiErrors(ex.getMessage(), detalles, status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errores);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<String> errors = new ArrayList<String>();


        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        ApiErrors errores = new ApiErrors("Datos inválidos", errors, HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);

    }



    @ExceptionHandler(idNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(RuntimeException ex) {
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(404), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errores);
    }

    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<Object> handleBusinessException(BussinesException ex) {
        List<String> detalles = new ArrayList<String>();
        String mensaje = "";
        ApiErrors errores = new ApiErrors(ex.getMessage(), HttpStatusCode.valueOf(422), LocalDateTime.now());
        return ResponseEntity.status(HttpStatusCode.valueOf(422)).body(errores);
    }
}
