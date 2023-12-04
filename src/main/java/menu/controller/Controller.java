package menu.controller;

import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {

    public void run() {
        OutputView.welcomeMessage();
        askCoachName();
    }

    private void askCoachName() {
        new Coach(InputView.askCoachName());

    }

}
