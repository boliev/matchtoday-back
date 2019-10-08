package ru.matchtoday.Parser.Exception;

public class WrongCountryException extends RuntimeException {
    public WrongCountryException(String message) {
        super(message);
    }
}
