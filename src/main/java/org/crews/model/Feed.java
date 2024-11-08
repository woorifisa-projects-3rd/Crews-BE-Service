package org.crews.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feed extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @Column(nullable = false)
    private String content;

    @ColumnDefault("0")
    private String likeCount;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agit agit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "feed")
    private List<Heart> likes = new ArrayList<>();
}
