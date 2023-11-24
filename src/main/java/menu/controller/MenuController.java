package menu.controller;

import menu.dto.TeamCoachesDto;
import menu.model.TeamCoaches;
import menu.util.Retry;
import menu.view.InputView;

public class MenuController {

    private final InputView inputView;

    public MenuController(InputView inputView) {
        this.inputView = inputView;
    }


    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");

        TeamCoaches teamCoaches = Retry.retryOnException(inputView::requestInputCoach);
        System.out.println(teamCoaches.getTeamCoaches());

        TeamCoachesDto teamCoachesDto = new TeamCoachesDto(teamCoaches.getTeamCoaches());

        inputView.requestInputCoachDoNotEat(teamCoachesDto);

    }

}
