package io.pragra.learning.jpademo.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    @ApiModelProperty(example = "You need to take rest")
    private String messsage;
    private LocalDateTime timeStamp;
    @ApiModelProperty(example = "202")
    private String errorCode;
}
