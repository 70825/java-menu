package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foods {
    private static final List<String> foods = new ArrayList<>();

    public static void addFood(String name) {
        foods.add(name);
    }

    public static List<String> getFoods() {
        return Collections.unmodifiableList(foods);
    }
}
