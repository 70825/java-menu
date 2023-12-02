package menu.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Menus {

    private final List<Menu> menus = new ArrayList<>();

    public Menus(List<Menu> menus) {
        this.menus.addAll(menus);
    }

    public Menus() {
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public void addAll(List<Menu> menu) {
        menus.addAll(menu);
    }

    public boolean isInvalidMenu(Menu menu) {
        return menus.contains(menu);
    }

    public List<String> getNames() {
        return menus.stream()
                .map(Menu::getName)
                .collect(toList());
    }
}
