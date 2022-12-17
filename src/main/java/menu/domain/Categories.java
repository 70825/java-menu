package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Categories {

    private static final List<Category> categories = new ArrayList<>();

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static List<Category> getCategories() {
        return categories;
    }

    public static boolean findByName(String name) {
        AtomicBoolean flag = new AtomicBoolean(false);
        categories.forEach(category -> {
            if (category.findByName(name)) {
                flag.set(true);
            }
        });

        return flag.get();
    }
}
