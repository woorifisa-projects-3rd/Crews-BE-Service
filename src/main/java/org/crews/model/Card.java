package org.crews.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String maskedCardNumber;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private LocalDateTime registeredAt;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
