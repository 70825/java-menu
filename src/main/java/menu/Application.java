package menu;

import menu.controller.MainController;

import static menu.config.AppConfig.coachService;
import static menu.config.AppConfig.menuService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MainController mainController = new MainController(menuService(), coachService());
        mainController.run();
    }
}
