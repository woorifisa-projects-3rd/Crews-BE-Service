package org.crews.dto.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseDto {
    private String customerName;
    private String bankName;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public AccountResponseDto(String customerName, String bankName, String accountNumber, String accountType, BigDecimal balance, LocalDate createdAt, LocalDate updatedAt) {
        this.customerName = customerName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
