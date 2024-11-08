package org.crews.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.crews.dto.core.AccountResponseDto;
import org.crews.dto.core.MemberToCoreDto;
import org.crews.model.Member;
import org.crews.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final CoreService coreService;

    public List<AccountResponseDto> getAccountInfoFromCore(Long id) {
        Member member = memberRepository
                .findById(id).orElseThrow(() -> new IllegalStateException("해당 회원을을 찾을 수 없습니다."));
        log.info("{} : {}",member.getName(),member.getPhoneNumber());
        return coreService.findCoreSideAccounts(MemberToCoreDto.fromEntity(member));
    }
}
