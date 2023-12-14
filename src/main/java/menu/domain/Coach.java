package menu.domain;

import menu.domain.menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {
    private String name;
    private List<Menu> hateMenu = new ArrayList<>();
    private Map<Weekday, Menu> recommendMenu = new HashMap<>();
}