package com.reviewApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// to handle the exception in generic way we created this class
public class ErrorDetails {

    private Date date;
    private String message;
    private String details;
}
