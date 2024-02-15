package br.com.fiap.postech.pagamento.web.controller;

import br.com.fiap.postech.pagamento.dominio.exception.DominioException;
import br.com.fiap.postech.pagamento.web.view.ErroDominioView;
import br.com.fiap.postech.pagamento.web.view.ErroValidacaoView;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(MethodArgumentNotValidException e) {
        Map<String, List<String>> campos = e.getBindingResult().getFieldErrors()
                .stream().collect(
                        Collectors.groupingBy(FieldError::getField,
                                Collectors.mapping(
                                        DefaultMessageSourceResolvable::getDefaultMessage,
                                        Collectors.toList()
                                )
                        )
                );

        ErroValidacaoView view = new ErroValidacaoView(campos);
        return new ResponseEntity<>(view, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(HttpRequestMethodNotSupportedException e) {
        return new ResponseEntity<>("", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(DominioException e) {
        ErroDominioView view = new ErroDominioView(e.getMessage());
        return new ResponseEntity<>(view, HttpStatus.valueOf(e.getCodigo()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(BadCredentialsException e) {
        return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handle(final NoHandlerFoundException ex) {
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handle(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
