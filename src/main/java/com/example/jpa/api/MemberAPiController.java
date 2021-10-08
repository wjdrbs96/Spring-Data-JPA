package com.example.jpa.api;

import com.example.jpa.domain.Member;
import com.example.jpa.dto.ResultDTO;
import com.example.jpa.dto.request.CreateMemberRequestDTO;
import com.example.jpa.dto.request.UpdateRequestDTO;
import com.example.jpa.dto.response.CreateMemberResponseDTO;
import com.example.jpa.dto.response.MemberResponseDTO;
import com.example.jpa.dto.response.UpdateMemberResponseDTO;
import com.example.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by Gyunny 2021/10/07
 */
@RequestMapping("/api/v2/members")
@RequiredArgsConstructor
@RestController
public class MemberAPiController {

    private final MemberService memberService;

    @GetMapping
    public ResultDTO findMembers() {
        List<Member> members = memberService.findMembers();
        return new ResultDTO<>(members.stream()
                .map(member -> new MemberResponseDTO(member.getUsername()))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public CreateMemberResponseDTO saveMemberV2(@RequestBody CreateMemberRequestDTO requestDTO) {
        return new CreateMemberResponseDTO(memberService.join(requestDTO.toEntity()));
    }

    @PutMapping("/{memberId}")
    public UpdateMemberResponseDTO updateMemberV2(@PathVariable Long memberId, @RequestBody UpdateRequestDTO requestDTO) {
        memberService.update(memberId, requestDTO.getName());
        Member findMember = memberService.findOne(memberId);
        return new UpdateMemberResponseDTO(findMember.getId(), findMember.getUsername());
    }

}
