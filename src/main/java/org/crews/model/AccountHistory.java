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
public class AccountHistory extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TranType tranType;

    @Column(nullable = false)
    private LocalDateTime transactionTime;

    private String cardNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long transactionAmount;

    @Column(nullable = false)
    private Long AfterBalanceAmount;

}
