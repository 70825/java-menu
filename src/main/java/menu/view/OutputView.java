package menu.view;

import menu.domain.MenuCategory;

import java.util.List;

public class OutputView {
    private static final String WELCOME_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String RECOMMEND_COMPLETE_MESSAGE = "추천을 완료했습니다.";
    private static final String SORTATION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
    public static void welcomeMessage(){
        System.out.println(WELCOME_MESSAGE);
    }

    public static void recommendMenu(){
        System.out.println(RECOMMEND_RESULT_MESSAGE);
    }

    public static void printCategory(List<MenuCategory> category) {
        recommendMenu();
        System.out.println(SORTATION);
        System.out.printf(CATEGORY,category.get(ZERO),category.get(ONE),
                category.get(TWO),category.get(THREE),category.get(FOUR));

    }
}
