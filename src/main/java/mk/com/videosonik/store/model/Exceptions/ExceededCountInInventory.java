package mk.com.videosonik.store.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceededCountInInventory extends RuntimeException {

    public ExceededCountInInventory() {
    }

    public ExceededCountInInventory(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+" products only available!";
    }
}