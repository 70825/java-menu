package menu.controller;

import menu.domain.*;
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
        Menu menu = new Menu();
        menu.Recommend(chooseCategory.getCategory(),coach.getCoachNames());
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
