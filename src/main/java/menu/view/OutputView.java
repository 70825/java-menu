package menu.view;

import menu.domain.Coach;
import menu.domain.Day;

import java.util.Map;

public class OutputView {

    private enum OutputMessage {

        OUTPUT_INTRO_MESSAGE("점심 메뉴 추천을 시작합니다."),
        OUTPUT_RESULT("메뉴 추천 결과입니다.");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public static void outputIntro() {
        System.out.println(OutputMessage.OUTPUT_INTRO_MESSAGE.message);
        System.out.println();
    }

    public static void outputResult(Map<Coach, Map<Day, String>> recommendMenu, Map<Day, String> categoryByDay) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        printCategoryByDay(categoryByDay);

        // 출력: 코치별 메뉴
        printRecommendMenu(recommendMenu);

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private static void printRecommendMenu(Map<Coach, Map<Day, String>> recommendMenu) {
        for (Coach coach : recommendMenu.keySet()) {
            System.out.printf("[ %s |", coach.getName());
            Map<Day, String> coachMenu = recommendMenu.get(coach);
            printCoachMenu(coachMenu);
            System.out.println(" ]");
        }
    }

    private static void printCoachMenu(Map<Day, String> coachMenu) {
        for (Day day : Day.values()) {
            String menu = coachMenu.get(day);
            if (menu != null) {
                System.out.print(" " + menu);
            }

            if (day != Day.FRIDAY) {
                System.out.print(" |");
            }
        }
    }

    private static void printCategoryByDay(Map<Day, String> categoryByDay) {
        // 출력: 카테고리
        System.out.print("[ 카테고리 |");
        for (Day day : Day.values()) {
            System.out.printf(" %s", categoryByDay.get(day));
            if (day != Day.FRIDAY) {
                System.out.print(" |");
            }
        }
        System.out.println(" ]");
    }
}
