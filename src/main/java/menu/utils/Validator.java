package menu.utils;

import menu.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;

    private static final int MIN_COACH_LIST_SIZE = 2;
    private static final int MAX_COACH_LIST_SIZE = 5;

    private static final int MAX_HATE_MENU_SIZE = 2;

    public void validateCoachName(List<String> coachNames) {
        validateCoachListSize(coachNames);
        validateCoachNameDuplicate(coachNames);
        for (String name : coachNames) {
            validateCoachNameRegex(name);
            validateCoachNameLength(name);
        }
    }

    private void validateCoachNameDuplicate(List<String> coachNames) {
        Set<String> noDuplicateCoachNames = new HashSet<>(coachNames);

        if (coachNames.size() != noDuplicateCoachNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateCoachNameRegex(String name) {
        String pattern = "^[가-힣A-Za-z]*$";

        if (!name.matches(pattern)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_REGEX_ERROR_MESSAGE);
        }
    }

    private void validateCoachNameLength(String name) {
        if (name.length() < MIN_COACH_NAME_LENGTH || name.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateCoachListSize(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_LIST_SIZE || coachNames.size() > MAX_COACH_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.COACH_LIST_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateCoachHateMenuSize(List<String> hateMenuNames) {
        if (hateMenuNames.size() > MAX_HATE_MENU_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.HATE_MENU_SIZE_ERROR_MESSAGE);
        }
    }

}
