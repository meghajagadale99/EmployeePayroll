package com.example.employeepayrollapp.dto;

import lombok.*;
/**
 * Create and maintains response data in object.
 * class contains a message field and a general field for any type of data
 *
 * @author Megha Jagadale
 * @version 0.0.1
 * @since 14/8/2022
 */

public @Data class ResponseDTO {

    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
