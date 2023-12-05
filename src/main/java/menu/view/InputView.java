package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static menu.global.Error.NAME_RANGE_OUT;

public class InputView {
private static final String INPUT_NAME_MESSAGE = "%n코치의 이름을 입력해 주세요. (, 로 구분)%n";
private static final String INPUT_MENU_MESSAGE = "%n%s (이)가 못 먹는 메뉴를 입력해 주세요.%n";
private static final int MIN_COACH=2;
private static final int MAX_COACH=5;

    public static List<String> askCoachName() {
        System.out.printf(INPUT_NAME_MESSAGE);
        List<String> coachName = Arrays.asList(Console.readLine().split(","));
        validate(coachName);
        return coachName;
    }
    public static List<List<String>> askNonPreferred(List<String> coachNames) {
        List<List<String>> nonPreferredMenus = new ArrayList<>();
        for(String names : coachNames){
            System.out.printf(INPUT_MENU_MESSAGE,names);
            nonPreferredMenus.add( Arrays.asList(Console.readLine().split(",")));
        }
        return nonPreferredMenus;
    }
    private static void validate(List<String> coachName) {
        if(coachName.size()<MIN_COACH||coachName.size()>MAX_COACH){
            throw new IllegalArgumentException(NAME_RANGE_OUT.getMessage());
        }
    }
}
