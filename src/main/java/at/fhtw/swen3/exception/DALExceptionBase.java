package at.fhtw.swen3.exception;

public abstract class DALExceptionBase extends  Exception{

    DALExceptionBase(String message) {
        super(message);
    }
}
