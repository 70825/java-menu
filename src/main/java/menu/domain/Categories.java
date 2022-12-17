package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private static final List<Category> categories = new ArrayList<>();

    public static void addCategory(Category category) {
        categories.add(category);
    }

    public static List<Category> getCategories() {
        return categories;
    }
}
