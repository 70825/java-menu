package menu.dto;

import java.util.List;
import menu.model.coach.Coach;

public class TeamCoachesDto {

    private final List<Coach> teamCoaches;

    public TeamCoachesDto(List<Coach> teamCoaches) {
        this.teamCoaches = teamCoaches;
    }

    public List<Coach> getTeamCoaches() {
        return teamCoaches;
    }
}
