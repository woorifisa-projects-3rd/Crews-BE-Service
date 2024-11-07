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
public class Agit extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ColumnDefault("10")
    private Integer maxPerson;

    @ColumnDefault("1")
    private Integer currentPerson;

    @Column(nullable = false)
    private boolean isDue;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @OneToMany(mappedBy = "agit")
    List<Membership> memberships = new ArrayList<>();

    @OneToMany(mappedBy = "agit")
    List<InterestingAndAgit> interestingAndAgits = new ArrayList<>();

    @OneToMany(mappedBy = "agit")
    List<Feed> feeds = new ArrayList<>();

    @OneToMany(mappedBy = "agit")
    List<Introducing> introducings = new ArrayList<>();

    @OneToMany(mappedBy = "agit")
    List<RegularCrewing> regularCrewings = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Dues dues;

    @OneToMany(mappedBy = "agit")
    private List<AgitAndAccount> agitAndAccounts = new ArrayList<>();

}
