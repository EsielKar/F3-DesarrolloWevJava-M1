package org.bedu.postwork_7.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Data
@Builder
public class ResponseErrorDTO {
    private String message;
    private List<String> errors;
}
