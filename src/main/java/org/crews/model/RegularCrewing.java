package org.crews.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegularCrewing extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agit agit;

    private String image;

    @Column(nullable = false)
    private String regular_name;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private String placeAddress;

    @Column(nullable = false)
    private LocalDateTime regularTime;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
