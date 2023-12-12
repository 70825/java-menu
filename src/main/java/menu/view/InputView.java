package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.Converter;

import java.util.List;

public class InputView {

    private enum InputMessage {

        INPUT_COACH_NAMES_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }
    public static List<String> inputCoachName(){
        System.out.println(InputMessage.INPUT_COACH_NAMES_MESSAGE.message);
         return Converter.splitWithComma(Console.readLine());
    }
}
