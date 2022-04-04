package lkd.namsic.minyee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
public class Response {
    
    public Response() {
        this.status = HttpStatus.OK.value();
        this.message = "Success";
    }
    
    int status;
    String message;
    
}
