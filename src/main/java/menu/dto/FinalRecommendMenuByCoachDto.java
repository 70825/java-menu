package menu.dto;

import java.util.List;
import menu.model.coach.Coach;

public class FinalRecommendMenuByCoachDto {

    private final Coach coach;
    private final List<String> foods;

    public FinalRecommendMenuByCoachDto(Coach coach, List<String> foods) {
        this.coach = coach;
        this.foods = foods;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<String> getFoods() {
        return foods;
    }
}
