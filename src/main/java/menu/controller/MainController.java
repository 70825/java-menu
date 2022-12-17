package menu.controller;

import menu.service.InitService;
import menu.view.MainView;

import java.util.List;

public class MainController {
    private static final String NEWLINE = "\n";
    InitService initService = new InitService();

    public void start() {
        initService.init();

        try {
            MainView.printMainScreen();
            List<String> names = MainView.getMainValue();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + NEWLINE);
        }
    }
}
