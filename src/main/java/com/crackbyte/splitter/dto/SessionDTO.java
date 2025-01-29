package com.crackbyte.splitter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {
    private Long id;

    private String token;
    private Integer userId;
    private String lastLogin;
    private String expirationTime;
    private String createdAt;
}
