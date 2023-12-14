package menu.service;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private List<Coach> coaches = new ArrayList<>();

    public void initCoaches(List<String> coachNames) {
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
    }

}
