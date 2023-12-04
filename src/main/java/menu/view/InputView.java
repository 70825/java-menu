package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
private static final String INPUT_NAME_MESSAGE = "%n코치의 이름을 입력해 주세요. (, 로 구분)%n";
private static final String INPUT_MENU_MESSAGE = "%n%s (이)가 못 먹는 메뉴를 입력해 주세요.";
private static final int MIN_COACH=2;
private static final int MAX_COACH=5;

    public static List<String> askCoachName() {
        System.out.printf(INPUT_NAME_MESSAGE);
        List<String> coachName = Arrays.asList(Console.readLine().split(","));

        return coachName;
    }


}
