package com.jay.vote.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {

    private String message;

    @Builder.Default
    private HttpStatus status = HttpStatus.OK;

    public boolean isSuccess() {
        return status == HttpStatus.OK;
    }
}
