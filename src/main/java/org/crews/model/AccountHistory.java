package org.crews.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
public class AccountHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InOutType inOutType;

    @Column(nullable = false)
    private LocalDateTime transactionType;

    private String cardNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long transactionAmount;

    @Column(nullable = false)
    private Long AfterBalanceAmount;

}
