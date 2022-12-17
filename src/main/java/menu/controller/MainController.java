package menu.controller;

import menu.domain.Categories;
import menu.domain.Category;
import menu.service.InitService;
import menu.service.RandomService;
import menu.view.MainView;
import menu.view.NotEatView;
import menu.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainController {
    private static final String NEWLINE = "\n";
    InitService initService = new InitService();
    RandomService randomService = new RandomService();
    public static final HashMap<String, List<String>> people = new HashMap<>();

    public void start() {
        initService.init();

        MainView.printMainScreen();

        while (true) {
            try {
                people.clear();
                List<String> names = MainView.getMainValue();
                startNotEat(names);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + NEWLINE);
            }
        }
    }

    private void startNotEat(List<String> names) {
        names.forEach(name -> {
            people.put(name, NotEatView.getNotEatValue(name));
        });

        startPick(names);
    }

    private void startPick(List<String> names) {
        List<String> weekCategory = randomService.randomGetCategory();
        List<List<String>> resultMenu = new ArrayList<>();

        List<String> monday = randomService.randomGetMenu(weekCategory.get(0), names);
        List<String> tuesday = randomService.randomGetMenu(weekCategory.get(1), names);
        List<String> wednesday = randomService.randomGetMenu(weekCategory.get(2), names);
        List<String> thursday = randomService.randomGetMenu(weekCategory.get(3), names);
        List<String> friday = randomService.randomGetMenu(weekCategory.get(4), names);

        resultMenu.add(monday);
        resultMenu.add(tuesday);
        resultMenu.add(wednesday);
        resultMenu.add(thursday);
        resultMenu.add(friday);

        ResultView.printResult();
        ResultView.printCategory(weekCategory);
        ResultView.printAll(names, resultMenu);
        ResultView.printEnd();
    }
}
