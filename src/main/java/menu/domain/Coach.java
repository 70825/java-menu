package menu.domain;

import menu.constant.ErrorMessage;

import javax.xml.stream.events.Namespace;
import java.util.*;

public class Coach {
    private String name;
    private List<Menu> hateMenus = new ArrayList<>();
    private Map<Weekday, Menu> recommendMenu = new LinkedHashMap<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void initHateMenus(List<String> hateMenus) {
        try {
            for (String hateMenu : hateMenus) {
                Menu menu = Menu.findMenu(hateMenu);
                this.hateMenus.add(menu);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.HATE_MENU_ERROR_MESSAGE);
        }
    }


    public boolean validateRecommendMenu(String menuName) {
        return nonContainCommendMenu(menuName) && notContainHateMenu(menuName);
    }
    public boolean notContainHateMenu(String menuName) {
        for (Menu hateMenu : hateMenus) {
            if (hateMenu.getName().equals(menuName)) {
                return false;
            }
        }

        return true;
    }

    public boolean nonContainCommendMenu(String menuName) {
        Collection<Menu> values = recommendMenu.values();
        for (Menu menu : values) {
            if (menu.equals(menuName)) {
                return false;
            }
        }
        return true;
    }

    public void addRecommendMenu(Weekday weekday, Menu menu) {
        recommendMenu.put(weekday, menu);
    }

    public String recommendToString() {
        List<String> result = new ArrayList<>();
        result.add(name);
        Collection<Menu> values = recommendMenu.values();
        for (Menu value : values) {
            result.add(value.getName());
        }
        return String.join(" | ", result);
    }
}