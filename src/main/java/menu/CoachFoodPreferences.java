package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoachFoodPreferences {
    private HashMap<String, List<String>> coachFoodPreferences;

    public CoachFoodPreferences(HashMap<String, List<String>> coachFoodPreferences) {
        this.coachFoodPreferences = coachFoodPreferences;
    }

    public HashMap<String, List<String>> getCoachFoodPreferences() {
        return coachFoodPreferences;
    }

    public List<String> getCoachNames() {
        return new ArrayList<>(coachFoodPreferences.keySet());
    }
}
