package com.rmc.ejerciciosT6.domain;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class ExceptionBody {
    private LocalDateTime timestamp;
    private HttpStatusCode status;
    private String message;
    private String path;
}
