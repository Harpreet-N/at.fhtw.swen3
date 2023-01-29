package at.fhtw.swen3.services;

public abstract class BLException extends Exception {
    protected BLException(String message) {
        super(message);
    }
}
