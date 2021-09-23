package com.example.chatrooms.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public Object accessCustomException(RuntimeException ex, WebRequest request) {
        return response(ex, request);
    }

    private Object response(RuntimeException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.FORBIDDEN);
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replaceFirst("uri=", ""));
        log.error("Exception : " + ex.getClass().getName() + ", " + body);
        ex.printStackTrace();
        return new ResponseEntity<>(body, headers, HttpStatus.FORBIDDEN);
    }
}
