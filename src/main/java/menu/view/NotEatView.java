package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Foods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotEatView {
    private static final String NEWLINE = "\n";

    private static final String NOT_EAT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public static List<String> getNotEatValue(String name) {
        System.out.printf(NOT_EAT_MESSAGE + NEWLINE, name);

        try {
            String result = Console.readLine();
            List<String> resultArray = Arrays.stream(result.split(",")).collect(Collectors.toList());
            validate(resultArray);
            return resultArray;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}
