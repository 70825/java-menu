package menu.model;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.DoNotEatFoodByCoachDto;
import menu.dto.FinalRecommendMenuByCoachDto;
import menu.model.coach.Coach;
import menu.model.food.Food;
import menu.model.food.RecommendFood;

public class Manager {
    // 코치별 먹지 못하는 음식 리스트
    // 추천되는 음식 리스트
    // 를 받아서 이를 비교하면서 잘 못된 추천 음식리스트를 제공 받을 경우 다시 추천을 요청해야함

    private final DoNotEatFoodByCoachDto doNotEatFoodByCoachDto;

    public FinalRecommendMenuByCoachDto recommend() {
        Coach coach = doNotEatFoodByCoachDto.getCoach();
        List<String> collect = doNotEatFoodByCoachDto.getFoods().stream()
            .map(Food::getName).collect(Collectors.toList());

        List<String> recommendFood = RecommendFood.recommendFood();

        for (String food : recommendFood) {
            if (collect.contains(food)) {
                throw new IllegalStateException("[ERROR] 코치별 먹을 수 있는 음식을 다시 추천해주세요");
            }
        }

        // 최종적으로 추천받은 음식을 리턴해야함
        return new FinalRecommendMenuByCoachDto(coach, recommendFood);
    }

    public Manager(DoNotEatFoodByCoachDto doNotEatFoodByCoachDto) {
        this.doNotEatFoodByCoachDto = doNotEatFoodByCoachDto;
    }


}
