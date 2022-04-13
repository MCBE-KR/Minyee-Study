package com.test.wa.test.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 15)
    String name;

    @Column
    Integer age;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    School school;
}
