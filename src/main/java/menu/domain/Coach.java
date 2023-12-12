package menu.domain;

import java.util.ArrayList;
import java.util.List;

import static menu.error.ErrorMessage.*;

public class Coach {

    private String name;
    private List<String> dislikeMenu;

    public Coach(String name) {
        validateCoach(name);
        this.name = name;
        dislikeMenu = new ArrayList<>();
    }

    public void setDislikeMenu(List<String> dislikeMenu) {
        validateDislikeMenu(dislikeMenu);
        this.dislikeMenu = dislikeMenu;
    }

    public String getName() {
        return name;
    }

    public List<String> getDislikeMenu() {
        return dislikeMenu;
    }

    private void validateCoach(String name) {
        checkName(name);
    }

    private void validateDislikeMenu(List<String> dislikeMenu) {
        checkDislikeMenuCount(dislikeMenu);
    }

    private void checkName(String name) {
        if (!isNameValid(name)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_ERROR.getMessage());
        }
    }

    private void checkDislikeMenuCount(List<String> dislikeMenu) {
        if (!isValidDislikeMenuCount(dislikeMenu)) {
            throw new IllegalArgumentException(INVALID_DISLIKE_MENU_COUNT_ERROR.getMessage());
        }
    }

    private boolean isNameValid(String name) {
        return 2 <= name.length() && name.length() <= 4;
    }

    private boolean isValidDislikeMenuCount(List<String> dislikeMenu) {
        return 0 <= dislikeMenu.size() && dislikeMenu.size() <= 2;
    }
}
