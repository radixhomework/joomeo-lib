package io.github.radixhomework.model;

import lombok.Data;

@Data
public class Error {

    private Integer internalCode;
    private String endUserMessage;
    private String internalMessage;

}
