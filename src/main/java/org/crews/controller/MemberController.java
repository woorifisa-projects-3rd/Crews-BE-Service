package org.crews.controller;

import lombok.RequiredArgsConstructor;
import org.crews.dto.core.AccountResponseDto;
import org.crews.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me/agits-account-info")
    public ResponseEntity<List<AccountResponseDto>> getAccountInfoFromCore(){
        // TODO:JWT 인증로직
        // TODO: 인증된 유저의 id 찾아오기
        // TODO: 인증된 유저의 id 로 인자 바꾸기 getAccountInfoFromCore(여기)
        return ResponseEntity.ok(memberService.getAccountInfoFromCore(1L));
    }


}
