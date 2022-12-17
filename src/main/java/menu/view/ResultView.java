package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    private static final String NEWLINE = "\n";

    private static final String RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String ONE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String THREE = "[ %s | %s | %s | %s | %s | %s ]";

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
        System.out.println(ONE);
    }

    public static void printCategory(List<String> category) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ 카테고리 | ", " ]");

        category.forEach(stringJoiner::add);

        System.out.println(stringJoiner);
    }
}
