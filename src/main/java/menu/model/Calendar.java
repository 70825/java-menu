package menu.model;

public enum Calendar {
    월요일("월요일"), 화요일("화요일"), 수요일("수요일"), 목요일("목요일"), 금요일("금요일"),
    ;

    private String day;

    Calendar(String day) {
        this.day = day;
    }

}
