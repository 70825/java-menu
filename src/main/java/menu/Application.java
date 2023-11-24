package menu;

import menu.controller.MenuController;
import menu.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        MenuController menuController = new MenuController(inputView);
        menuController.run();

    }
}
