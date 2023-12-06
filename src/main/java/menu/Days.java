package menu;

import java.util.Arrays;
import java.util.List;

public enum Days {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String nameInKorean;

    Days(String nameInKorean) {
        this.nameInKorean = nameInKorean;
    }

    public String getNameInKorean() {
        return nameInKorean;
    }

    public static List<Days> getDays() {
        return Arrays.asList(values());
    }
}
