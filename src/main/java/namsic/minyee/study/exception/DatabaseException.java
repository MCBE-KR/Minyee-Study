package namsic.minyee.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DatabaseException extends RuntimeException {

    public DatabaseException(String reason) {
        super(reason);
    }
}
