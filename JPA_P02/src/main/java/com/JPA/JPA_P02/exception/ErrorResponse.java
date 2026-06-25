package com.JPA.JPA_P02.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    String message;
    int status;
    LocalDateTime timeStamp;
}
