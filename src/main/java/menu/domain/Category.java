package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static String name;
    private static List<String> foods;

    public Category(String name, List<String> foods) {
        this.name = name;
        this.foods = foods;
    }

    public void addFood(String name) {
        foods.add(name);
    }

    public Boolean findByName(String name) {
        int result = (int) foods.stream()
                .filter(food -> food.equals(name))
                .count();

        if (result != 0) {
            return true;
        }

        return false;
    }
}

