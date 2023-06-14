package org.bedu.postwork_8.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseErrorDTO {
    private String message;
    private List<String> errors;
}
