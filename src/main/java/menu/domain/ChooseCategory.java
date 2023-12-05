package menu.domain;

import java.util.EnumMap;
import java.util.Map;

import static menu.domain.MenuCategory.*;

public class ChooseCategory {
    final Map<MenuCategory, Integer> map = new EnumMap<>(MenuCategory.class);
    public ChooseCategory(){
        map.put(JAPANESE, 1);
        map.put(KOREAN, 2);
        map.put(CHINESE, 3 );
        map.put(ASIAN, 4);
        map.put(WESTERN, 5);
    }
    public void choose() {

    }
}
