package com.test.wa.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@AllArgsConstructor
public class Response {

    public Response() {
        this.status = HttpStatus.OK.value();
        this.message = "success";
    }

    int status;
    String message;
}
