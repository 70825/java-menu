package menu.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static menu.domain.MenuCategory.*;

public class ChooseCategory {
    final Map<Integer, MenuCategory> map = new HashMap<>();
    public ChooseCategory(){
        map.put(1, JAPANESE);
        map.put(2, KOREAN);
        map.put(3, CHINESE );
        map.put(4, ASIAN);
        map.put(5, WESTERN);
    }
    public void choose() {

    }
}
