package menu;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WeeklyCategory {
    private LinkedHashMap<Days, Categories> weeklyCategory;

    public WeeklyCategory(LinkedHashMap<Days, Categories> weeklyCategory) {
        this.weeklyCategory = weeklyCategory;
    }

    public List<Days> getWeeklyCategory() {
        return new ArrayList<>(weeklyCategory.keySet());
    }

    public Categories getCategoryByDay(Days day) {
        return weeklyCategory.get(day);
    }

    public List<String> getDaysInKorean() {
        List<String> daysInKorean = new ArrayList<>();
        for (Days day : weeklyCategory.keySet()) {
            daysInKorean.add(day.getNameInKorean());
        }
        return daysInKorean;
    }

    public List<String> getCategoriesInKorean() {
        List<String> categoriesInKorean = new ArrayList<>();
        for (Categories category : weeklyCategory.values()) {
            categoriesInKorean.add(category.getNameInKorean());
        }
        return categoriesInKorean;
    }

    public String getDaysLine() {
        List<String> koreanDays = getDaysInKorean();
        String daysLine = "[ 구분 | " + String.join(" | ", koreanDays) + " ]";
        return daysLine;
    }

    public String getCategoriesLine() {
        List<String> koreanCategories = getCategoriesInKorean();
        String categoriesLine = "[ 카테고리 | " + String.join(" | ", koreanCategories) + " ]";
        return categoriesLine;
    }

}
