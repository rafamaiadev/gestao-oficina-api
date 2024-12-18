package br.com.gestao_oficina_api.errors;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class StandardError implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(Long timeStamp, Integer status, String error, String message, String path) {
        super();
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
