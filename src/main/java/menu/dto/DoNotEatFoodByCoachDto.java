package menu.dto;

import java.util.List;
import menu.model.coach.Coach;
import menu.model.food.Food;

public class DoNotEatFoodByCoachDto {

    private final Coach coach;
    private final List<Food> foods;


    public DoNotEatFoodByCoachDto(Coach coach, List<Food> foods) {
        this.coach = coach;
        this.foods = foods;
    }

    @Override
    public String toString() {
        return coach.toString() + " | " + foods;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
