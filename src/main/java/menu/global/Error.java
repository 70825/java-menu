package menu.global;

public enum Error {
    NAME_RANGE_OUT("코치는 최소 2명 이상 5명 이하로 입력해야 합니다.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = ERROR+message;
    }

    public String getMessage() {
        return message;
    }
}
