package menu;

public enum Categories {
    JAPANESE("양식"),
    KOREAN("한식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String nameInKorean;

    Categories(String nameInKorean) {
        this.nameInKorean = nameInKorean;
    }

    public String getNameInKorean() {
        return nameInKorean;
    }

    public static Categories get(int randomNumber) {
        if (randomNumber == 1) {
            return Categories.JAPANESE;
        }
        if (randomNumber == 2) {
            return Categories.KOREAN;
        }
        if (randomNumber == 3) {
            return Categories.CHINESE;
        }
        if (randomNumber == 4) {
            return Categories.ASIAN;
        }
        if (randomNumber == 5) {
            return Categories.WESTERN;
        }
        throw new IllegalArgumentException("Invalid randomNumber: " + randomNumber);
    }

}
