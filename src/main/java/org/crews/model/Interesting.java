package org.crews.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Interesting extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @OneToMany(mappedBy = "interesting")
    private List<MemberAndInteresting> memberAndInterestings = new ArrayList<>();

    @OneToMany(mappedBy = "interesting")
    private List<InterestingAndAgit> interestingAndAgits = new ArrayList<>();
}
