package menu;


import java.util.Map;

public class MenuRecommendator {
    private Map<Days, Categories> weeklyCategory;

    public MenuRecommendator(Map<Days, Categories> weeklyCategory) {
        this.weeklyCategory = weeklyCategory;
    }

    public Map<Days, Categories> getWeeklyCategory() {
        return weeklyCategory;
    }

}
