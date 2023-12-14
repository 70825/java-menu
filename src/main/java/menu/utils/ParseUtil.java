package menu.utils;

import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public static List<String> stringToStringList(String value) {
        return Arrays.asList(value.split(","));
    }
}
