package com.jay.vote.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionTranslator {

    @ExceptionHandler(ServiceException.class)
    public ProblemDetail serviceExceptionHandlerError(ServiceException serviceException) {
        log.error("service exception", serviceException);
        ProblemDetail problemDetail = ProblemDetail.forStatus(serviceException.getStatus());
        problemDetail.setType(URI.create("http://vote.com"));
        problemDetail.setTitle("服务器异常");
        problemDetail.setDetail(String.format("错误信息，%s", serviceException.getMessage()));
        return problemDetail;
    }

    @ExceptionHandler(Throwable.class)
    public ProblemDetail handlerError(Throwable throwable) {
        log.error("internal server error", throwable);
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setType(URI.create("http://vote.com"));
        problemDetail.setTitle("服务器异常");
        problemDetail.setDetail(String.format("错误信息，%s", throwable.getMessage()));
        return problemDetail;
    }
}
