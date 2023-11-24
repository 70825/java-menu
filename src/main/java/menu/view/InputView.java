package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.dto.DoNotEatFoodByCoachDto;
import menu.dto.TeamCoachesDto;
import menu.model.coach.Coach;
import menu.model.coach.TeamCoaches;
import menu.model.food.Food;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public TeamCoaches requestInputCoach() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = scanner.nextLine();
        return new TeamCoaches(input);
    }

    public List<DoNotEatFoodByCoachDto> requestInputCoachDoNotEat(TeamCoachesDto teamCoachesDto) {
        System.out.println();
        List<DoNotEatFoodByCoachDto> doNotEatFoodByCoachDtos = new ArrayList<>();

        for (Coach teamCoach : teamCoachesDto.getTeamCoaches()) {
            System.out.println(teamCoach.getName() + "(이)가 못 먹는 메뉴를 입력해 주세요.");
            String input = scanner.nextLine();

            List<Food> foods = Food.getFoodsByInput(input);
            DoNotEatFoodByCoachDto doNotEatFoodByCoachDto = new DoNotEatFoodByCoachDto(teamCoach,
                foods);
            doNotEatFoodByCoachDtos.add(doNotEatFoodByCoachDto);
            System.out.println();
        }

        return doNotEatFoodByCoachDtos;
    }
}

