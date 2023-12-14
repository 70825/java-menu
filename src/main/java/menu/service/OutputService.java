package menu.service;

import java.util.List;

public class OutputService {
    public static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String MENU_RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    public static final String SERVICE_CLOSE_MESSAGE = "추천을 완료했습니다.";
    public static final String WEEKDAY_SECTION_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    public static final String START_MESSAGE = "[ ";
    public static final String FINISH_MESSAGE = " ]";

    public void printServiceStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printMenuRecommendResult(String categories, List<String> recommendMenus) {
        System.out.println(MENU_RECOMMEND_RESULT_MESSAGE);
        System.out.println(WEEKDAY_SECTION_MESSAGE);
        printCategories(categories);
        printRecommendMenus(recommendMenus);
    }

    private void printCategories(String categories) {
        System.out.print(START_MESSAGE);
        System.out.print("카테고리 | ");
        System.out.print(categories);
        System.out.println(FINISH_MESSAGE);
    }

    private void printRecommendMenus(List<String> recommendMenus) {
        for (String recommendMenu : recommendMenus) {
            System.out.print(START_MESSAGE);
            System.out.print(recommendMenu);
            System.out.println(FINISH_MESSAGE);
        }
    }

    public void printServiceCloseMessage() {
        System.out.println(SERVICE_CLOSE_MESSAGE);
    }

}
