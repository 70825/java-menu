package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import menu.MenuBoard;
import menu.constants.ErrorMessage;

public class InputView {
    public static List<String> getCoachesInput() {
        try {
            String input = Console.readLine();
            validateCoachesInput(input);
            return convertToList(input);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getCoachesInput();
        }
    }

    public static List<String> getFoodPreferencesInput(String coach) {
        try {
            OutputView.requestFoodPreferenceInput(coach);
            String input = Console.readLine();
            validateFoodPreferences(input);
            return convertToList(input);
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getFoodPreferencesInput(coach);
        }
    }

    public static void validateCoachesInput(String input) {
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_FORMAT_ERROR);
        }
        if (!isValidCountForCoaches(input)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_COUNT_ERROR);
        }
        if (!isValidLengthForCoach(input)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_LENGTH_ERROR);
        }
        if (!isUnique(input)) {
            throw new IllegalArgumentException(ErrorMessage.COACH_DUPLICATION_ERROR);
        }
    }

    public static void validateFoodPreferences(String input) {
        if (!isValidFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFERENCE_FORMAT_ERROR);
        }
        if (!isInMenuBoard(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFERENCE_NOT_IN_MENUBOARD_ERROR);
        }
        if (!isValidCountForPreference(input)) {
            throw new IllegalArgumentException(ErrorMessage.PREFERENCE_COUNT_ERROR);
        }
    }

    private static boolean isValidCountForCoaches(String input) {
        String[] coaches = input.split(",");
        if (coaches.length >= 2 && coaches.length <= 5) {
            return true;
        }
        return false;
    }

    private static boolean isValidLengthForCoach(String input) {
        String[] coaches = input.split(",");
        for (String coach : coaches) {
            int coachLength = coach.trim().length();
            if (coachLength < 2 || coachLength > 4) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnique(String input) {
        String[] strings = input.split(",");
        HashSet<String> set = new HashSet<>(Arrays.asList(strings));
        if (set.size() != strings.length) {
            return false;
        }
        return true;
    }

    private static boolean isValidCountForPreference(String input) {
        String[] preference = input.split(",");
        if (preference.length >= 0 && preference.length <= 2) {
            return true;
        }
        return false;
    }

    private static boolean isValidFormat(String input) {
        if (input.trim().isEmpty()) {
            return true;
        }
        String[] strings = input.split(",");

        for (String str : strings) {
            if (!str.matches("[a-zA-Z0-9가-힣]+")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInMenuBoard(String input) {
        if (input.trim().isEmpty()) {
            return true;
        }

        String[] strings = input.split(",");
        for (String str : strings) {
            if (MenuBoard.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> convertToList(String input) {
        List<String> list = new ArrayList<>();
        String[] coaches = input.split(",");
        for (String coach : coaches) {
            list.add(coach);
        }
        return list;
    }
}
