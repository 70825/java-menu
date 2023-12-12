package menu.util.valid;

public class InputValidator {



    private static void checkInputEmpty(String input, String errorMessage) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
