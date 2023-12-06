package menu.constants;

public class Constant {
    String daysLine = "[ 구분 | " + String.join(" | ", koreanDays) + " ]";
    String categoriesLine = "[ 카테고리 | " + String.join(" | ", koreanCategories) + " ]";
    String line = "[ " + entry.getKey() + " | " + String.join(" | ", entry.getValue()) + " ]";
}
