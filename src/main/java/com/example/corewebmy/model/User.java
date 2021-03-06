package com.example.corewebmy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.example.corewebmy.config.Constants.USERNAME_PASSWORD;

@Data
@ToString(exclude = {"id", "password", "cashPassword"})
@EqualsAndHashCode(exclude = {"id", "password", "cashPassword"})
@Builder(builderMethodName = "of", buildMethodName = "create")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty(value = "id")
    private long id;

    @NotNull
    @Size(min = 3, max = 10, message = "userName must be from 3 to 10 characters")
    @Pattern(regexp = USERNAME_PASSWORD, message = "check userName")
    @JsonProperty(value = "userName")
    private String userName;

    @NotNull
    @JsonProperty(value = "firstName")
    private String firstName;

    @NotNull
    @JsonProperty(value = "lastName")
    private String lastName;

    @NotNull
    @JsonProperty(value = "password")
    @Size(min=6, message = "Password must be bigger")
    @Pattern(regexp = USERNAME_PASSWORD, message = "change password")
    private String password;


    private String hashPassword;

}
