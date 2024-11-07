package org.crews.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Address extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String addressDo;

    @Column(nullable = false)
    private String addressSi;

    @Column(nullable = false)
    private String addressGuGun;

    @Column(nullable = false)
    private String addressDong;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
