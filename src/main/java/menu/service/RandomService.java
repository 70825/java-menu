package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class RandomService {

    public List<String> randomGetCategory() {
        List<String> resultCategories = new ArrayList<>();

        while(resultCategories.size() != 5) {
            int categoryNum = Randoms.pickNumberInRange(1, 5);
            String result = transferCategory(categoryNum);
            if (resultCategories.stream().filter(name -> name.equals(result)).count() < 2) {
                resultCategories.add(result);
            }
        }

        return resultCategories;
    }

    private String transferCategory(int val) {
        if (val == 1) {
            return "일식";
        }
        if (val == 2) {
            return "한식";
        }
        if (val == 3) {
            return "중식";
        }
        if (val == 4) {
            return "아시안";
        }
        if (val == 5) {
            return "양식";
        }
        throw new IllegalArgumentException("[ERROR]");
    }
}
