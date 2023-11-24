package menu.controller;

import java.util.List;
import menu.dto.DoNotEatFoodByCoachDto;
import menu.dto.FinalRecommendMenuByCoachDto;
import menu.dto.TeamCoachesDto;
import menu.model.Manager;
import menu.model.coach.TeamCoaches;
import menu.util.Retry;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        outputView.printStartRecommend();

        TeamCoaches teamCoaches = Retry.retryOnException(inputView::requestInputCoach);

        TeamCoachesDto teamCoachesDto = new TeamCoachesDto(teamCoaches.getTeamCoaches());

        List<DoNotEatFoodByCoachDto> doNotEatFoodByCoachDtos = Retry.retryOnExceptionWithParam(
            inputView::requestInputCoachDoNotEat, teamCoachesDto);

        outputView.printResultRecommend();
        outputView.printCalendar();
        outputView.printCategory();
        outputView.printResult(doNotEatFoodByCoachDtos);
        outputView.printCompleted();
    }
}
