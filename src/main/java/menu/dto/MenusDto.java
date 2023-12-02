package menu.dto;

import menu.domain.Category;

import java.util.List;

public class MenusDto {

    private final List<Category> categories;
    private final List<MenuDto> menus;

    public MenusDto(List<Category> categories, List<MenuDto> menus) {
        this.categories = categories;
        this.menus = menus;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<MenuDto> getMenus() {
        return menus;
    }
}
