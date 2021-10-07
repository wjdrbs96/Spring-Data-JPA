package com.example.jpa.dto.response;

import lombok.Getter;

/**
 * created by Gyunny 2021/10/07
 */
@Getter
public class CreateMemberResponseDTO {

    private final Long id;

    public CreateMemberResponseDTO(Long id) {
        this.id = id;
    }

}
