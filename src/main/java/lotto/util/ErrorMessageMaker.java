package lotto.util;

public class ErrorMessageMaker {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String NULL_ERROR_MESSAGE = "메세지는 널이 되면 안됩니다.";

    private ErrorMessageMaker() {
    }

    public static String getErrorMessage(String message) {
        if (message == null) {
            throw new NullPointerException(getErrorMessage(NULL_ERROR_MESSAGE));
        }
        return ERROR_MESSAGE_FORMAT.formatted(message);
    }
}
