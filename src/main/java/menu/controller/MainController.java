package menu.controller;

import menu.domain.Categories;
import menu.service.InitService;
import menu.view.MainView;
import menu.view.NotEatView;

import java.util.HashMap;
import java.util.List;

public class MainController {
    private static final String NEWLINE = "\n";
    InitService initService = new InitService();
    HashMap<String, List<String>> people = new HashMap<>();

    public void start() {
        initService.init();

        while (true) {
            try {
                people.clear();
                MainView.printMainScreen();
                List<String> names = MainView.getMainValue();
                startNotEat(names);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + NEWLINE);
            }
        }
    }

    private void startNotEat(List<String> names) {
        names.forEach(name -> {
            people.put(name, List.of());
            people.put(name, NotEatView.getNotEatValue(name));
        });
    }
}
