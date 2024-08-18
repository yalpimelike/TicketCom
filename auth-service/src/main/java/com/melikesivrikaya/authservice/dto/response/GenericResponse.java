package com.melikesivrikaya.authservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResponse<T> {

    private String status;
    private String message;
    private HttpStatus httpStatus;
    private T data;

    public static <T> GenericResponse<T> success(T data, HttpStatus httpStatus) {
        return GenericResponse.<T>builder()
                .httpStatus(httpStatus)
                .status(GenericResponseConstants.SUCCESS)
                .message(null)
                .data(data)
                .build();
    }

    public static <T> GenericResponse<T> failed(String message) {
        return GenericResponse.<T>builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .status(GenericResponseConstants.FAILED)
                .message(message)
                .data(null)
                .build();
    }


}
