package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.domain.Menu;

import java.util.*;

public class RecommendService {

    private Map<Coach, Map<Day, String>> recommendMenu = new LinkedHashMap<>();
    private Map<Day, String> categoryByDay = new LinkedHashMap<>();

    public RecommendService(Coaches coaches) {
        initCoaches(coaches);
    }

    public void recommendMenuByDay() {
        for (Day day : Day.values()) {
            // 카테고리 설정
            setCategoryByDay(day);
            String category = categoryByDay.get(day);

            // 코치마다 메뉴 추천

            for (Coach coach : recommendMenu.keySet()) {
                setRecommendMenuByDay(coach, day, category);
            }
        }
    }

    public Map<Coach, Map<Day, String>> getRecommendMenu() {
        return recommendMenu;
    }

    public Map<Day, String> getCategoryByDay() {
        return categoryByDay;
    }

    private void setRecommendMenuByDay(Coach coach, Day day, String category) {
        try {
            String pickedMenu = pickRecommendMenu(category, coach.getDislikeMenu());
            validateRecommendMenu(coach, pickedMenu);
            recommendMenu.get(coach).put(day, pickedMenu);
        } catch (IllegalArgumentException e) {
            setRecommendMenuByDay(coach, day, category);
        }
    }

    private String pickRecommendMenu(String category, List<String> dislikeMenu) {
        List<String> menuByCategory = new ArrayList<>(Menu.getMenuByCategory(category));
        menuByCategory.removeAll(dislikeMenu);

        return Randoms.shuffle(menuByCategory).get(0);
    }

    private void initCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            HashMap<Day, String> coachMenu = new HashMap<>();
            recommendMenu.put(coach, coachMenu);
        }
    }

    private void setCategoryByDay(Day day) {
        try {
            String category = RandomSerivce.pickRandomCategories();
            validateCateygory(category);
            categoryByDay.put(day, category);
        } catch (IllegalArgumentException e) {
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

    private boolean isMenuDuplicate(Coach coach, String menu) {
        for (String m : recommendMenu.get(coach).values()) {
            if (m.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private void validateRecommendMenu(Coach coach, String menu) {
        if (isMenuDuplicate(coach, menu)) {
            throw new IllegalArgumentException("Invalid recommendation menu");
        }
    }
}
