package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Menu;

public class RandomSerivce {

    public static String pickRandomCategories() {
        return Menu.getCategoryByCode(Randoms.pickNumberInRange(1, 5));
    }
}
