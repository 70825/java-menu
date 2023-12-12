package menu.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    private static final String COMMA = ",";

    public static List<String> splitWithComma(String input) {
        return Stream.of(input.split(COMMA))
                .collect(Collectors.toList());
    }
}
