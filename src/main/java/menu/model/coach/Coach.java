package menu.model.coach;

import java.util.List;
import menu.model.food.Food;

public class Coach {

    private final String name;

    private List<Food> doNotEat;

    public Coach(String name) {
        this.name = name;
    }

    public static Coach from(String input) {
        return new Coach(input);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
