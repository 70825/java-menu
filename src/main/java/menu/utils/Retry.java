package menu.utils;

import menu.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public class Retry {

    private static final OutputView outputView = new OutputView();

    public static <T> T execute(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return execute(supplier);
        }
    }

    public static <T, R> R execute(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return execute(function, input);
        }
    }

    public static void execute(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            execute(runnable);
        }
    }
}