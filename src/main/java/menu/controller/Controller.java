package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Day;
import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {


    public void run() {

        OutputView.outputIntro();

        Coaches coaches = inputCoachName();

        setDislikeMenu(coaches);

        RecommendService recommendService = new RecommendService(coaches);

        recommendService.recommendMenuByDay();


        Map<Coach, Map<Day, String>> recommendMenu = recommendService.getRecommendMenu();
        Map<Day, String> categoryByDay = recommendService.getCategoryByDay();

        OutputView.outputResult(recommendMenu, categoryByDay);

    }

    private Coaches inputCoachName() {
        try {
            List<String> coachNames = InputView.inputCoachName();
            return makeCoaches(coachNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoachName();
        }
    }

    private List<String> inputDislikeMenu(String coachName) {
        try {
            return InputView.inputDislikeMenu(coachName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputDislikeMenu(coachName);
        }
    }

    private void setDislikeMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> dislikeMenu = inputDislikeMenu(coach.getName());
            coach.setDislikeMenu(dislikeMenu);
        }
    }

    private Coaches makeCoaches(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }
}
