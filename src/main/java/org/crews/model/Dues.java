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
public class Dues extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dues")
    private List<Agit> agits = new ArrayList<>();

    @Column(nullable = false)
    private String memberData;

    @Column(nullable = false)
    private Byte dueDate;

    @Column(nullable = false)
    private Long dueAmount;

}
