package io.pragra.learning.jpademo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String messsage;
    private LocalDateTime timeStamp;
    private String errorCode;
}
