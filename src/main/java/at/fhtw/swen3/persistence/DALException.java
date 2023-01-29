package at.fhtw.swen3.persistence;

public abstract class DALException extends Exception {

    DALException(String message) {
        super(message);
    }
}
