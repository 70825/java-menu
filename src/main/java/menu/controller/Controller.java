package menu.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import menu.Categories;
import menu.CoachFoodPreferences;
import menu.Days;
import menu.MenuRecommendator;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void init() {
        CoachFoodPreferences coachFoodPreferences = enrollCoaches();
        MenuRecommendator menuRecommendator = initCategory();
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

    public MenuRecommendator initCategory() {
        Map<Days, Categories> weeklyCategory = new HashMap<>();
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
        return new MenuRecommendator(weeklyCategory);
    }

    private boolean isCategoryExceedsMaxFrequency(Categories category, Map<Categories, Integer> categoryFrequency) {
        return categoryFrequency.getOrDefault(category, 0) >= 3;
    }

    private void updateCategoryFrequency(Categories category, Map<Categories, Integer> categoryFrequency) {
        categoryFrequency.put(category, categoryFrequency.getOrDefault(category, 0) + 1);
    }
}
