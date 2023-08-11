package com.Register.Login.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto {

    @Schema(description = "Full Name",example = "John Owen", required = true)
    private String name;

    @Schema(description = "Username",example = "jOHNoWEN", required = true)
    private String username;

    @Schema(description = "Password",example = "<PASSWORD>", required = true)
    private String password;
}
