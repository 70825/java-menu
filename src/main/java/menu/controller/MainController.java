package menu.controller;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.dto.CoachNameDto;
import menu.dto.InvalidMenusDto;
import menu.dto.MenusDto;
import menu.service.CoachService;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

import static menu.utils.Retry.execute;

public class MainController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final MenuService menuService;
    private final CoachService coachService;

    public MainController(MenuService menuService, CoachService coachService) {
        this.menuService = menuService;
        this.coachService = coachService;
    }

    public void run() {
        outputView.printStart();
        execute(this::saveCoach);
        execute(this::recommendMenu);
        outputView.printEnd();
    }

    private void saveCoach() {
        CoachNameDto coachNameDto = execute(inputView::readCoachNames);
        coachService.saveCoach(coachNameDto);
    }

    private void recommendMenu() {
        List<Coach> coaches = coachService.findAll();
        for (Coach coach : coaches) {
            InvalidMenusDto invalidMenusDto = execute(inputView::readMenuNames, coach.getName());
            coach.addInvalidMenus(invalidMenusDto.getMenus());
        }
        MenusDto result = menuService.recommendMenus(coaches);
        outputView.printMenuMessage(result);
    }
}
