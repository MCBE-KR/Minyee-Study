package lkd.namsic.minyee.service;

import lkd.namsic.minyee.dto.Response;
import lkd.namsic.minyee.dto.StudentDto;

public interface MainService {
    
    Response post();
    Response addStudent(StudentDto studentDto);
    
}
