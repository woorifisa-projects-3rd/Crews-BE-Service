package org.crews.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    private String profileImage;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @OneToMany(mappedBy = "member")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Membership> memberships = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberAndInteresting> memberAndInterestings = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Feed> feeds = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Yaggwan> yaggwans = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Card> cards = new ArrayList<>();

}
