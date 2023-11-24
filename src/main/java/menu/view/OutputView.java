package menu.view;

import java.util.List;
import menu.dto.DoNotEatFoodByCoachDto;
import menu.dto.FinalRecommendMenuByCoachDto;
import menu.model.Calendar;
import menu.model.Manager;
import menu.model.food.FoodCategory;
import menu.util.Retry;

public class OutputView {

    public void printStartRecommend() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printResultRecommend() {
        System.out.println("메뉴 추천 결과입니다.");
    }

    public void printCalendar() {
        System.out.print("[ 구분");
        System.out.print(
            " | " + Calendar.월요일 + " | " + Calendar.화요일 + " | " + Calendar.수요일 + " | "
                + Calendar.목요일 + " | " + Calendar.금요일);
        System.out.print(" ]");
        System.out.println();
    }

    public void printCategory() {
        System.out.print("[ 카테고리");
        System.out.print(
            " | " + FoodCategory.한식 + " | " + FoodCategory.양식 + " | " + FoodCategory.일식 + " | "
                + FoodCategory.중식 + " | " + FoodCategory.아시안);
        System.out.print(" ]");
        System.out.println();
    }

    public void printResult(List<DoNotEatFoodByCoachDto> doNotEatFoodByCoachDtos) {
        for (DoNotEatFoodByCoachDto doNotEatFoodByCoachDto : doNotEatFoodByCoachDtos) {
            Manager manager = new Manager(doNotEatFoodByCoachDto);

            FinalRecommendMenuByCoachDto recommend = Retry.retryOnException(manager::recommend);
            String output =
                "[ " + recommend.getCoach() + " | " + String.join(" | ", recommend.getFoods())
                    + " ]";
            System.out.println(output);
        }
    }

    public void printCompleted() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

}