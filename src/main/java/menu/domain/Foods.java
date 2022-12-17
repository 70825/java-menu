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

    public static Boolean findByName(String name) {
        int result = (int) foods.stream()
                .filter(food -> food.equals(name))
                .count();

        if (result != 0) {
            return true;
        }

        return false;
    }
}
