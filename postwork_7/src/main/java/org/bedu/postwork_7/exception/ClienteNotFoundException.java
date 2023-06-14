package org.bedu.postwork_7.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mapstruct.Builder;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClienteNotFoundException extends RuntimeException{
    private HttpStatus code;
    private String msg;

}
