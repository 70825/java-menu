package menu.service;

import java.sql.SQLOutput;

public class OutputService {
    public static final String SERVICE_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    public static final String MENU_RECOMMEND_RESULT = "메뉴 추천 결과입니다.";
    public static final String SERVICE_CLOSE_MESSAGE = "추천을 완료했습니다.";

    public void printServiceStartMessage() {
        System.out.println(SERVICE_START_MESSAGE);
    }

    public void printServiceCloseMessage() {
        System.out.println(SERVICE_CLOSE_MESSAGE);
    }
}
