package com.example.jpa.api;

import com.example.jpa.dto.request.CreateMemberRequestDTO;
import com.example.jpa.dto.response.CreateMemberResponseDTO;
import com.example.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Gyunny 2021/10/07
 */
@RequestMapping("/api/v2")
@RequiredArgsConstructor
@RestController
public class MemberAPiController {

    private final MemberService memberService;

    @PostMapping("/members")
    public CreateMemberResponseDTO saveMemberV2(@RequestBody CreateMemberRequestDTO requestDTO) {
        return new CreateMemberResponseDTO(memberService.join(requestDTO.toEntity()));
    }

}
