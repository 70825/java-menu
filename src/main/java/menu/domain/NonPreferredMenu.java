package menu.domain;

import java.util.List;

public class NonPreferredMenu {
    private final List<List<String>> nonPreferredMenus;
    public NonPreferredMenu(List<List<String>> nonPreferredMenus) {
        this.nonPreferredMenus = nonPreferredMenus;
    }

    public List<List<String>> getCoachNames() {
        return nonPreferredMenus;
    }
}
