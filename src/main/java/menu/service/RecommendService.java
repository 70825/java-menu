package menu.service;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Menu;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecommendService {

    private Map<Coach, Map<Day, Menu>> recommendMenu = new LinkedHashMap<>();
    private Map<Day, String> categoryByDay = new LinkedHashMap<>();

    public RecommendService(Coaches coaches) {
        initCoaches(coaches);
    }

    private void initCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            HashMap<Day, Menu> coachMenu = new HashMap<>();
            recommendMenu.put(coach, coachMenu);
        }
    }

    private void setCategoryByDay(Day day) {
        try {
            String category = RandomSerivce.pickRandomCategories();
            validateCateygory(category);
            categoryByDay.put(day, category);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setCategoryByDay(day);
        }
    }

    private void validateCateygory(String category) {
        checkCategoryCount(category);
    }

    private void checkCategoryCount(String category) {
        if (!isValidCategory(category)) {
            throw new IllegalArgumentException("Invalid category");
        }
    }

    private boolean isValidCategory(String category) {
        long count = categoryByDay.values().stream()
                .filter(c -> c.equals(category))
                .count();

        return count <= 2;
    }
}
