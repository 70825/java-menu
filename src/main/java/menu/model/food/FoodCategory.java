package menu.model.food;

public enum FoodCategory {
    일식("일식", 1), 한식("한식", 2), 중식("중식", 3), 아시안("아시안", 4), 양식("양식",
        5),없음("없음",0);

    private final String name;

    private final int number;

    FoodCategory(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {

        return this.number;
    }
}
