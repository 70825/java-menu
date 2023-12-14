package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.MenuCategory;
import menu.domain.Weekday;

import java.util.*;

public class MenuService {
    private final static int MAX_CATEGORY_DUPLICATE_COUNT = 2;

    private List<Coach> coaches = new ArrayList<>();
    private Map<Weekday, MenuCategory> categories = new LinkedHashMap<>();

    public void initCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void initCoachHateMenus(List<String> hateMenus, Coach coach) {
        coach.initHateMenus(hateMenus);
    }



    public void drawRecommend() {
        List<MenuCategory> recommendCategories = drawRecommendCategory();
        for (int i = 0; i < Weekday.values().length; i++) {
            categories.put(Weekday.values()[i], recommendCategories.get(i));
            drawRecommendMenu(Weekday.values()[i], recommendCategories.get(i));
        }
        System.out.println(categories);

    }

    private List<MenuCategory> drawRecommendCategory() {
        List<MenuCategory> menuCategories = new ArrayList<>();
        while (menuCategories.size() < Weekday.values().length) {
            int randomNumber = Randoms.pickNumberInRange(1, MenuCategory.values().length);
            MenuCategory category = MenuCategory.values()[randomNumber - 1];

            if (Collections.frequency(menuCategories, category) < MAX_CATEGORY_DUPLICATE_COUNT) {
                menuCategories.add(category);
            }
        }
        return menuCategories;
    }

    private void drawRecommendMenu(Weekday weekday, MenuCategory menuCategory) {
        for (Coach coach : coaches) {
            Menu menu = choiceMenu(menuCategory, coach);
            coach.addRecommendMenu(weekday, menu);
        }
    }

    private Menu choiceMenu(MenuCategory menuCategory, Coach coach) {
        while (true) {
            String randomMenu = Menu.choiceMenu(menuCategory);
            if (coach.validateRecommendMenu(randomMenu)) {
                return Menu.findMenu(randomMenu);
            }
        }
    }

    public String getCategories() {
        List<String> names = new ArrayList<>();
        Collection<MenuCategory> values = categories.values();
        for (MenuCategory value : values) {
            names.add(value.getCategory());
        }
        return String.join(" | ", names);
    }

    public List<String> getRecommendMenus() {
        List<String> recommendMenus = new ArrayList<>();
        for (Coach coach : coaches) {
            recommendMenus.add(coach.recommendToString());
        }

        return recommendMenus;
    }
}
