package menu.view;

import java.util.List;
import java.util.Scanner;
import menu.dto.TeamCoachesDto;
import menu.model.Coach;
import menu.model.TeamCoaches;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public TeamCoaches requestInputCoach() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = scanner.nextLine();
        return new TeamCoaches(input);
    }

    public void requestInputCoachDoNotEat(TeamCoachesDto teamCoachesDto) {
        List<Coach> teamCoaches = teamCoachesDto.getTeamCoaches();
        for (Coach teamCoach : teamCoaches) {
            System.out.println(teamCoach + "(이)가 못 먹는 메뉴를 입력해주세요");
        }
    }
}
