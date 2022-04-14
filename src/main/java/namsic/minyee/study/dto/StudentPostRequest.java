package namsic.minyee.study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPostRequest {

    private String name;
    private Integer age;
    private String schoolName;
    
}
