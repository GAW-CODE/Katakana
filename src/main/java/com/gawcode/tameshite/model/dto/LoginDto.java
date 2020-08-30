package com.gawcode.tameshite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class LoginDto {
    @Size(min = 1, max = 50)
    private String username;

    @Size(min = 1, max = 50)
    private String password;

    private boolean remember;
}
