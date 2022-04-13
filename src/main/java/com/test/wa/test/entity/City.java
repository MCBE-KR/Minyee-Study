package com.test.wa.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 31, unique = true)
    String name;

    @Builder.Default
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    List<School> schoolList = new ArrayList<>();
}
