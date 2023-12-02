package menu.service;

import menu.domain.Coach;
import menu.domain.Menu;
import menu.dto.CoachNameDto;
import menu.repository.CoachRepository;

import java.util.List;

public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public void saveCoach(CoachNameDto coachNames) {
        coachRepository.saveAll(coachNames.getNames());
    }

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }
}
