package namsic.minyee.study.dto;

import namsic.minyee.study.entity.Student;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
public class ObjectResponse extends Response {
    
    private Map<String, AbstractResponse> data = new HashMap<>();

    public ObjectResponse(Student student) {
        StudentResponse studentResponse = StudentResponse.create(student);
        this.data.put("student", studentResponse);
    }
    
    public ObjectResponse(List<Student> studentList) {
        this.data.put("studentList", StudentListResponse.create(studentList));
    }
    
}
