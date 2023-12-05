package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

import static menu.domain.MenuCategory.*;

public class ChooseCategory {
    private static final int MAX_ALLOW_DUPLICATION = 2;
    private static final int MAX_ATTEMPTS = 3;
    final Map<Integer, MenuCategory> map = new HashMap<>();
    private final List<MenuCategory> choicesCategory = new ArrayList<>();

    public ChooseCategory() {
        map.put(1, JAPANESE);
        map.put(2, KOREAN);
        map.put(3, CHINESE);
        map.put(4, ASIAN);
        map.put(5, WESTERN);
    }

    public void choose() {
        IntStream.range(0, 5)
                .mapToObj(i -> generateUniqueValue(map))
                .forEach(choicesCategory::add);

    }

    private MenuCategory generateUniqueValue(Map<Integer, MenuCategory> map) {
        MenuCategory value = null;
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            int randomKey = Randoms.pickNumberInRange(1, 5);  // 실제로는 여기에서 랜덤 값 추출

            value = map.get(randomKey);
            if (value != null && countOccurrences(choicesCategory, value) < MAX_ALLOW_DUPLICATION) {
                return value;
            }
        }

        return generateUniqueValue(map);
    }

    private int countOccurrences(List<MenuCategory> choices, MenuCategory value) {
        return (int) choices.stream()
                .filter(choice -> choice.equals(value))
                .count();
    }

    public List<MenuCategory> getCategory() {
        return this.choicesCategory;
    }
}