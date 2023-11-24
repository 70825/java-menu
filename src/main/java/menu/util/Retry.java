package menu.util;

import java.util.function.Function;
import java.util.function.Supplier;

public class Retry {

    public static <T> T retryOnException(Supplier<T> operation) {
        try {
            return operation.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return retryOnException(operation);
        } catch (IllegalStateException exception) {
            return retryOnException(operation);
        }
    }

    public static <T, R> R retryOnExceptionWithParam(Function<T, R> operation, T param) {
        try {
            return operation.apply(param);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return retryOnExceptionWithParam(operation, param);
        }
    }
}
