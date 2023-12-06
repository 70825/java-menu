package menu;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommendation {
    public LinkedHashMap<String, List<String>> getMenuRecommendation() {
        return menuRecommendation;
    }

    LinkedHashMap<String, List<String>> menuRecommendation;

    public MenuRecommendation(LinkedHashMap<String, List<String>> menuRecommendation) {
        this.menuRecommendation = menuRecommendation;
    }
}
