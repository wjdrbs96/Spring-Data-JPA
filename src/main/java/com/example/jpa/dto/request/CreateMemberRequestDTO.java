package com.example.jpa.dto.request;

import com.example.jpa.domain.Member;
import lombok.Getter;

/**
 * created by Gyunny 2021/10/07
 */
@Getter
public class CreateMemberRequestDTO {

    private String name;

    public Member toEntity() {
        return new Member(name);
    }

}
