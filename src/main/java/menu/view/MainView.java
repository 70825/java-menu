package menu.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainView {
    private static final String NEWLINE = "\n";

    private static final String MAIN_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_MESSAGE = "코치의 이름을 입력해주세요. (, 로 구분)";


    public static void printMainScreen() {
        System.out.println(MAIN_MESSAGE);
        System.out.printf(NEWLINE);
    }

    public static List<String> getMainValue() {
        System.out.println(INPUT_MESSAGE);

        String result = Console.readLine();
        try {
            List<String> resultArray = Arrays.stream(result.split(",")).collect(Collectors.toList());
            validate(resultArray);
        } catch (IllegalArgumentException e) {

        }
    }
}
