package by.epam.number.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NumberParameterNotValidException extends RuntimeException {
    private final String parameter;
    private final String reason;

    public NumberParameterNotValidException(String parameter, String reason) {
        super("Неверно указано значение параметра [" + parameter + "]: " + reason);
        this.parameter = parameter;
        this.reason = reason;
    }
}
