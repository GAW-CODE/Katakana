package com.gawcode.toraiautsu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
public class LoginDto {
    @Size(min = 1, max = 50)
    private final String username;

    @Size(min = 1, max = 50)
    private final String password;

    private final boolean remember;
}
