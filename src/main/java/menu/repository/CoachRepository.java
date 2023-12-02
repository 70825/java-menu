package menu.repository;

import menu.domain.Coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CoachRepository {

    private final List<Coach> repository = new ArrayList<>();

    public void saveAll(List<String> coachNames) {
        List<Coach> coaches = coachNames.stream()
                .map(Coach::new)
                .collect(toList());
        repository.addAll(coaches);
    }

    public List<Coach> findAll() {
        return Collections.unmodifiableList(repository);
    }
}
