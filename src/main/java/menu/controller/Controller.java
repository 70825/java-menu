package menu.controller;

import menu.domain.ChooseCategory;
import menu.domain.Coach;
import menu.domain.MenuCategory;
import menu.domain.NonPreferredMenu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    public void run() {
        OutputView.welcomeMessage();
        Coach coach = askCoachName();
        NonPreferredMenu nonPreferredMenu = askNonPreferred(coach.getCoachNames());
        ChooseCategory chooseCategory = new ChooseCategory();
        chooseCategory.choose();
        printCategory(chooseCategory.getCategory());
    }

    private void printCategory(List<MenuCategory> category) {
        OutputView.printCategory(category);
    }


    private NonPreferredMenu askNonPreferred(List<String> coachNames) {
        return new NonPreferredMenu(InputView.askNonPreferred(coachNames));
    }

    private Coach askCoachName() {
        while (true) {
            try {
                return new Coach(InputView.askCoachName());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }


    }

}
