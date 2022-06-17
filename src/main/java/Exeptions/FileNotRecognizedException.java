package Exeptions;

public class FileNotRecognizedException extends Exception {

    public FileNotRecognizedException() {
    }

    public FileNotRecognizedException(String message) {
        super(message);
    }

    public FileNotRecognizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotRecognizedException(Throwable cause) {
        super(cause);
    }

    public FileNotRecognizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
