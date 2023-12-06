package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;
import menu.Categories;
import menu.CoachFoodPreferences;
import menu.MenuRecommendation;
import menu.Days;
import menu.MenuBoard;
import menu.WeeklyCategory;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void init() {
        CoachFoodPreferences coachFoodPreferences = enrollCoaches();
        WeeklyCategory weeklyCategory = initCategory();
        MenuRecommendation menuRecommendation = generateMenuRecommendation(weeklyCategory, coachFoodPreferences);
        showResult(weeklyCategory, menuRecommendation);
    }

    public CoachFoodPreferences enrollCoaches() {
        HashMap<String, List<String>> temporaryMap = new HashMap<>();
        OutputView.requestCoachNameInput();
        List<String> coaches = InputView.getCoachesInput();
        for (String coach : coaches) {
            List<String> foodPreference = InputView.getFoodPreferencesInput(coach);
            temporaryMap.put(coach, foodPreference);
        }
        return new CoachFoodPreferences(temporaryMap);
    }

    public WeeklyCategory initCategory() {
        LinkedHashMap<Days, Categories> weeklyCategory = new LinkedHashMap<>();
        Map<Categories, Integer> categoryFrequency = new HashMap<>();
        List<Days> days = Days.getDays();

        for (Days day : days) {
            Categories category;
            do {
                category = Categories.get(Randoms.pickNumberInRange(1, 5));
            } while (isCategoryExceedsMaxFrequency(category, categoryFrequency));
            updateCategoryFrequency(category, categoryFrequency);
            weeklyCategory.put(day, category);
        }
        return new WeeklyCategory(weeklyCategory);
    }

    private boolean isCategoryExceedsMaxFrequency(Categories category, Map<Categories, Integer> categoryFrequency) {
        return categoryFrequency.getOrDefault(category, 0) >= 3;
    }

    private void updateCategoryFrequency(Categories category, Map<Categories, Integer> categoryFrequency) {
        categoryFrequency.put(category, categoryFrequency.getOrDefault(category, 0) + 1);
    }

    private MenuRecommendation generateMenuRecommendation(WeeklyCategory weeklyCategory,
                                                          CoachFoodPreferences coachFoodPreferences) {
        LinkedHashMap<String, List<String>> menuRecommendation = new LinkedHashMap<>();
        List<String> names = coachFoodPreferences.getCoachNames();
        List<Days> days = weeklyCategory.getWeeklyCategory();

        for (String name : names) {
            List<String> menus = new ArrayList<>();
            List<String> selectedMenus = new ArrayList<>();
            for (Days day : days) {
                Categories category = weeklyCategory.getCategoryByDay(day);
                String menu;
                do {
                    menu = getMenuMatchesCategory(category);
                } while (selectedMenus.contains(menu));
                selectedMenus.add(menu);
                menus.add(menu);
            }
            menuRecommendation.put(name, menus);
        }
        return new MenuRecommendation(menuRecommendation);
    }

    private String getMenuMatchesCategory(Categories category) {
        String menu;
        do {
            menu = Randoms.shuffle(MenuBoard.getMenus()).get(0);
        } while (!isMenuMatchesCategory(menu, category));

        return menu;
    }

    private boolean isMenuMatchesCategory(String menu, Categories category) {
        MenuBoard menuBoard = MenuBoard.valueOf(menu);

        return menuBoard.getType().equals(category);
    }

    public void showResult(WeeklyCategory weeklyCategory, MenuRecommendation menuRecommendation) {
        showDays(weeklyCategory);
        showCategories(weeklyCategory);
        showMenuRecommendation(menuRecommendation);
    }

    private void showDays(WeeklyCategory weeklyCategory) {
        String daysLine = weeklyCategory.getDaysLine();
        OutputView.printMessage(daysLine);
    }

    private void showCategories(WeeklyCategory weeklyCategory) {
        String categoriesLine = weeklyCategory.getCategoriesLine();
        OutputView.printMessage(categoriesLine);
    }

    private void showMenuRecommendation(MenuRecommendation menuRecommendation) {
        // 리팩토링 필요
        LinkedHashMap<String, List<String>> recommendation = menuRecommendation.getMenuRecommendation();
        for (Map.Entry<String, List<String>> entry : recommendation.entrySet()) {
            String menus = "[ " + entry.getKey() + " | " + String.join(" | ", entry.getValue()) + " ]";
            OutputView.printMessage(menus);
        }
    }
}
