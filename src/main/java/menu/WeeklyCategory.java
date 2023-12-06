package menu;


import java.util.LinkedHashMap;

public class WeeklyCategory {
    private LinkedHashMap<Days, Categories> weeklyCategory;

    public WeeklyCategory(LinkedHashMap<Days, Categories> weeklyCategory) {
        this.weeklyCategory = weeklyCategory;
        System.out.println(weeklyCategory);
    }

    public LinkedHashMap<Days, Categories> getWeeklyCategory() {
        return weeklyCategory;
    }

}
