package at.fhtw.swen3.exception.bl;

import lombok.Getter;

public class BLExceptionBase extends RuntimeException{

    @Getter
    private final String message;

    BLExceptionBase(String message) {
        super(message);
        this.message = message;
    }
}
