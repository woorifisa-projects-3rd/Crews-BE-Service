package org.crews.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bank extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bankCode;

    @Column(nullable = false)
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<Account> accounts = new ArrayList<>();
}
