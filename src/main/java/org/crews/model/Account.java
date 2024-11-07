package org.crews.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Account extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @Column(nullable = false)
    private String maskedAccountNumber;

    @Column(nullable = false)
    private String accountNumber;

    @ColumnDefault("0")
    private Long balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(nullable = false)
    private String fintecNumber;

    @Column(nullable = false)
    private String identifiedNumber;

    @OneToMany(mappedBy = "account")
    private List<AgitAndAccount> agitAndAccounts = new ArrayList<>();

    @OneToOne(mappedBy = "account")
    private AccountHistory accountHistory;

    @OneToMany(mappedBy = "account")
    private List<Card> cards = new ArrayList<>();

}
