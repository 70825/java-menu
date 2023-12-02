package menu.repository;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MenuRepository {

    private final Map<Category, Menus> repository = new EnumMap<>(Category.class);

    public void save(Category category, Menus menus) {
        repository.put(category, menus);
    }

    public List<String> findMenuNames(Category category) {
        Menus menus = repository.get(category);
        return menus.getNames();
    }
}
