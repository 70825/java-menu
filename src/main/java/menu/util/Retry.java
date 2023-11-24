package menu.util;

import java.util.function.Supplier;

public class Retry {

    public static <T> T retryOnException(Supplier<T> operation) {
        try {
            return operation.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return retryOnException(operation);
        }
    }
}
