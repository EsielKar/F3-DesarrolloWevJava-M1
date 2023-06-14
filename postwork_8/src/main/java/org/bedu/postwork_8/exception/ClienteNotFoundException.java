package org.bedu.postwork_8.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ClienteNotFoundException extends RuntimeException{
    private HttpStatus code;
    private String msg;

}
