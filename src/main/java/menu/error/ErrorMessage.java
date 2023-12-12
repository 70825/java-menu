package menu.error;

public enum ErrorMessage {
    INVALID_COACH_NAME_ERROR("코치 이름은 2글자 이상 4글자 이하입니다."),
    INVALID_COACH_COUNT_ERROR("코치는 2명 이상 5명 이하로 입력해야 합니다."),
    INVALID_DISLIKE_MENU_COUNT_ERROR("먹지 못하는 메뉴는 0개 이상 2개 이하입니다.");


    private final String message;
    private final String base = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = base + message;
    }

    public String getMessage() {
        return message;
    }
}
