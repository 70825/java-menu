package menu.model.coach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamCoaches {

    private final List<Coach> teamCoaches;

    public TeamCoaches(String teamCoaches) {
        validate(teamCoaches);
        this.teamCoaches = createCoach(teamCoaches);
    }

    private void validate(String input) {
        validateTeamCoachesNaming(input);
        validateTeamCoachesNamingRange(input);
        validateTeamCoachesCount(input);
        validateTeamCoachesDuplicatedName(input);
    }

    private void validateTeamCoachesNaming(String input) {
        if (!input.matches("([가-힣a-zA-Z]+)(,[가-힣a-zA-Z]+)*")) {
            throw new IllegalArgumentException("[ERROR] 코치 이름 입력은 ','로 구분되어야 합니다.");
        }
    }

    private void validateTeamCoachesNamingRange(String input) {
        String[] teamCoaches = input.split(",");
        for (String teamCoach : teamCoaches) {
            if (teamCoach.length() < 2 || teamCoach.length() > 4) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 최소 2글자, 최대 4글자 입니다");
            }
        }
    }

    private void validateTeamCoachesCount(String input) {
        String[] teamCoaches = input.split(",");
        if (teamCoaches.length < 2 || teamCoaches.length > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명까지 식사가 가능합니다.");
        }
    }

    private void validateTeamCoachesDuplicatedName(String input) {
        String[] teamCoaches = input.split(",");
        int teamCoachesCount = teamCoaches.length;
        Set<String> setTeamCoaches = new HashSet<>(Arrays.asList(teamCoaches));

        if (teamCoachesCount != setTeamCoaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치 이름을 유니크하게 입력해주세요.");
        }
    }

    private List<Coach> createCoach(String input) {
        List<Coach> teamCoaches = new ArrayList<>();

        String[] coaches = input.split(",");
        for (String coach : coaches) {
            Coach newCoach = Coach.from(coach);
            teamCoaches.add(newCoach);
        }

        return teamCoaches;
    }

    public List<Coach> getTeamCoaches() {
        return teamCoaches;
    }
}