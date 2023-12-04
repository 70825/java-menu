package menu.controller;

import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    public void run() {
        OutputView.welcomeMessage();
        askCoachName();
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
