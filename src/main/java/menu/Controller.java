package menu;

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


}
