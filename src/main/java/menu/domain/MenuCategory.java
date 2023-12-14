package menu.domain;

public enum MenuCategory {
    JAPAN("일식"),
    KOREA("한식"),
    CHINA("중식"),
    ASIA("아시안"),
    WESTERN("양식");

    private String category;

    MenuCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
