package menu;

import java.util.Arrays;
import java.util.List;

public enum Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public static List<Days> getDays() {
        return Arrays.asList(values());
    }
}
