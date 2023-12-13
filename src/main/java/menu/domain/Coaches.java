package menu.domain;

import java.util.List;

import static menu.error.ErrorMessage.*;

public class Coaches {

    private List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoaches(coaches);
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private void validateCoaches(List<Coach> coaches) {
        checkCoachCount(coaches);
    }

    private void checkCoachCount(List<Coach> coaches) {
        if (!isValidCoachCount(coaches)) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT_ERROR.getMessage());
        }
    }

    private boolean isValidCoachCount(List<Coach> coaches) {
        return 2 <= coaches.size() && coaches.size() <= 5;
    }

}
