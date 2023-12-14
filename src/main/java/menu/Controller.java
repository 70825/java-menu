package menu;

import menu.domain.Coach;
import menu.service.InputService;
import menu.service.MenuService;
import menu.service.OutputService;
import menu.utils.ParseUtil;
import menu.utils.Validator;

import java.util.List;

public class Controller {

    InputService inputService = new InputService();
    OutputService outputService = new OutputService();
    MenuService menuService = new MenuService();
    Validator validator = new Validator();

    public void run() {
        outputService.printServiceStartMessage();
        initCoachName();
        initCoachHateMenus();
        calculateResult();
        outputService.printServiceCloseMessage();
    }

    private void initCoachName() {
        while (true) {
            try {
                String inputCoachName = inputService.inputCoachNameMessage();
                List<String> coachNames = ParseUtil.stringToStringList(inputCoachName);
                validator.validateCoachName(coachNames);

                menuService.initCoaches(coachNames);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initCoachHateMenus() {
        List<Coach> coaches = menuService.getCoaches();
        for (Coach coach : coaches) {
            setCoachHateMenu(coach);
        }
    }



    private void setCoachHateMenu(Coach coach) {
        while (true) {
            try {
                String inputCoachHateMenu = inputService.inputCoachHateMenuMessage(coach.getName());
                if (inputCoachHateMenu.isEmpty() || inputCoachHateMenu == null) {
                    return;
                }
                List<String> coachHateMenu = ParseUtil.stringToStringList(inputCoachHateMenu);
                validator.validateCoachHateMenuSize(coachHateMenu);
                menuService.initCoachHateMenus(coachHateMenu, coach);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void calculateResult() {
//        String categories = menuService.getCategories();
//        outputService.printMenuRecommendResult(categories);

        menuService.drawRecommend();
        String categories = menuService.getCategories();
        List<String> recommendMenus = menuService.getRecommendMenus();
        outputService.printMenuRecommendResult(categories, recommendMenus);

//        menuService.getRecommendCategories();
    }


}
