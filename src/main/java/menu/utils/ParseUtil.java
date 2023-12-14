package menu.utils;

import menu.constant.ErrorMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    public static List<String> stringToStringList(String value) {
        return Arrays.asList(value.split(","));
    }

}
