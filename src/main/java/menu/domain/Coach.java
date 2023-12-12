package menu.domain;

import static error.ErrorMessage.*;

public class Coach {

    private String name;

    public Coach(String name) {
        validateCoach(name);
        this.name = name;
    }

    private void validateCoach(String name) {
        checkName(name);
    }

    private void checkName(String name) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_ERROR.getMessage());
        }
    }

    private boolean isNameValid(String name) {
        return 2 <= name.length() && name.length() <= 4;
    }
}
