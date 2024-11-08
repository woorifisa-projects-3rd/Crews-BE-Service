package org.crews.dto.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crews.model.Member;

@Getter
@Setter
@NoArgsConstructor
public class MemberToCoreDto {
    private String name;
    private String phoneNumber;

    public MemberToCoreDto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // 엔티티에서 DTO로 변환하는 메서드
    public static MemberToCoreDto fromEntity(Member member) {
        return new MemberToCoreDto(member.getName(), member.getPhoneNumber());
    }
}