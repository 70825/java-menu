package menu.domain;

public enum MenuCategory {
    JAPANESE("JAPANESE"),
    KOREAN("KOREAN"),
    CHINESE("CHINESE"),
    ASIAN("ASIAN"),
    WESTERN("WESTERN");

    private final String category;

    MenuCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
}
