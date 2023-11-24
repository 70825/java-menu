package menu.model.food;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.util.Retry;

public class RecommendFood {

    public static List<String> getRecommendFoods() {
        recommendFoods = Retry.retryOnException(RecommendFood::createAndValidateRecommendFood);

        return recommendFoods;
    }

    private static List<String> recommendFoods;


    public static RecommendFood generate() {
        recommendFoods = Retry.retryOnException(RecommendFood::createAndValidateRecommendFood);
        return new RecommendFood();
    }

    private static List<String> createAndValidateRecommendFood() {
        List<String> generatedFoods = recommendFood();
        validate(generatedFoods);
        return generatedFoods;
    }

    private static void validate(List<String> foods) {
        validaDuplicateMenu(foods);
        validateDuplicateMenuCategory(foods);
    }

    private static void validaDuplicateMenu(List<String> foods) {
        for (String food : foods) {
            if (Collections.frequency(foods, food) > 1) {
                throw new IllegalStateException("[ERROR] 동일한 메뉴는 추천 불가능합니다.");
            }
        }
    }

    private static void validateDuplicateMenuCategory(List<String> foods) {
        List<Integer> categoryNumbers = foods.stream()
            .map(Food::getFoodByName)
            .map(Food::getFoodCategoryNumber)
            .collect(Collectors.toList());

        for (Integer categoryNumber : categoryNumbers) {
            if (Collections.frequency(categoryNumbers, categoryNumber) > 2) {
                throw new IllegalStateException("[ERROR] 동일 카테고리 내 메뉴는 2회까지만 추천 가능합니다.");
            }
        }
    }

    public static List<String> recommendFood() {
        List<String> recommendFoods = new ArrayList<>();
        Food[] allFoods = Food.values();

        // 5번 추천해야함 -> 5일 추천
        for (int i = 0; i < 5; i++) {
            // 난수 값에 따라 어떤 카테고리를 추천할지 정함
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            // 난수 값에 선정된 카테고리에 있는 메뉴

            List<String> collectMenus = Arrays.stream(allFoods)
                .filter(food -> food.getFoodCategoryNumber() == randomNumber)
                .map(Food::getName)
                .collect(
                    Collectors.toList());
            // 정해진 카테고리에 있는 메뉴를 임의의 순서로 섞은 후, 첫 번째 값을 사용한다.
            String recommendMenu = Randoms.shuffle(collectMenus).get(0);
            recommendFoods.add(recommendMenu);
        }
        return recommendFoods;
    }
}
