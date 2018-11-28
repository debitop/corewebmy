package com.example.corewebmy.dto;

import com.example.corewebmy.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(builderMethodName = "of", buildMethodName = "create")
public class UserDto {
    @JsonProperty(value = "id")
    private long id;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "firstName")
    private String firstName;
    @JsonProperty(value = "lastName")
    private String lastName;

    public static interface UserDtoManager {
        static UserDto toUserDto(User user) {
            return UserDto.of()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .create();
        }
    }

}
