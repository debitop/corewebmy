package com.example.corewebmy.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(buildMethodName = "create", builderMethodName = "of")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {

    @JsonProperty(value = "httpStatus")
    private HttpStatus httpStatus;

    @JsonProperty(value = "error")
    private String error;

    @JsonProperty(value = "errorDescription")
    String errorDescription;

    private final long serialVersionUID = -138567463525437L;

}
