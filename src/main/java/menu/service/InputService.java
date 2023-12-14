package menu.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_COACH_HATE_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String inputCoachNameMessage() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return Console.readLine();
    }

    public String inputCoachHateMenuMessage(String coachName) {
        System.out.println(coachName + INPUT_COACH_HATE_MENU_MESSAGE);
        return Console.readLine();
    }
}
