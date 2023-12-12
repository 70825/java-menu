package menu.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {
    JAPANESE(1, "일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN(2, "한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE(3, "중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN(4, "아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN(5, "양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final int code;
    private final String category;
    private final List<String> menu;

    Menu(int code, String category, List<String> menu) {
        this.code = code;
        this.category = category;
        this.menu = menu;
    }

    public static String getCategoryByCode(int code) {
        return Arrays.stream(values())
                .filter(menu -> menu.code == code)
                .map(Menu::getCategory)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public static List<String> getMenuByCategory(String category) {
        return Arrays.stream(values())
                .filter(menu -> menu.category.equals(category))
                .map(Menu::getMenu)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 카테고리입니다."));
    }

    public int getCode() {
        return code;
    }

    public String getCategory() {
        return category;
    }

    public List<String> getMenu() {
        return menu;
    }
}
