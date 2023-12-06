package menu.view;

public class OutputView {
    public static void requestCoachNameInput() {
        printMessage("점심 메뉴 추천을 시작합니다.");
        printNewLine();
        printMessage("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void requestFoodPreferenceInput(String name) {
        printMessage(name + " (이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
