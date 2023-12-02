package menu.dto;

import menu.domain.Menu;

import java.util.List;

public class InvalidMenusDto {

    private final List<Menu> menus;

    public InvalidMenusDto(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
