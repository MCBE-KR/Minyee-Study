package lkd.namsic.minyee.entity;

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
public class School {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(length = 31, unique = true)
    String name;
    
    @Builder.Default
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    List<Student> studentList = new ArrayList<>();
    
}
