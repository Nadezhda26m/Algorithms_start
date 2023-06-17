package hw.ex6;

public class NoSuchFormatException extends Exception {
    public NoSuchFormatException() {
        this("Ошибка формата");
    }

    public NoSuchFormatException(String message) {
        super(message);
    }

    public NoSuchFormatException(Throwable cause) {
        super(cause);
    }
}
