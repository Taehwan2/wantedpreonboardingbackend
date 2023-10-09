package com.wantedpreonboardingbackend.response;


import com.wantedpreonboardingbackend.error.BusinessLogicException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class Response{

    @Getter
    @Setter
    @AllArgsConstructor
    public static class SuccessResponse<T> implements Serializable {
        private T data;
        private HttpStatus states;

    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class ErrorResponse {
        private BusinessLogicException businessLogicException;

    }
    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class API<t> {
        private  t body ;
        private Pagination pagination;
    }
}
