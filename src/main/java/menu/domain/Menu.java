package menu.domain;

public enum Menu {

    // Japanese
    GYUDON("규동", CuisineType.JAPANESE),
    UDON("우동", CuisineType.JAPANESE),
    MISOSHIRU("미소시루", CuisineType.JAPANESE),
    SUSHI("스시", CuisineType.JAPANESE),
    KATSUDON("가츠동", CuisineType.JAPANESE),
    ONIGIRI("오니기리", CuisineType.JAPANESE),
    HAYARICE("하이라이스", CuisineType.JAPANESE),
    RAMEN("라면", CuisineType.JAPANESE),
    OKONOMIYAKI("오코노미야끼", CuisineType.JAPANESE),
    // Korean
    KIMBAP("김밥", CuisineType.KOREAN),
    KIMCHI_STEW("김치찌개", CuisineType.KOREAN),
    SSAM_BAP("쌈밥", CuisineType.KOREAN),
    DOENJANG_STEW("된장찌개", CuisineType.KOREAN),
    BIBIMBAP("비빔밥", CuisineType.KOREAN),
    KALGUKSU("칼국수", CuisineType.KOREAN),
    BULGOGI("불고기", CuisineType.KOREAN),
    TTEOKBOKKI("떡볶이", CuisineType.KOREAN),
    JAEYUK_BOKKEUM("제육볶음", CuisineType.KOREAN),
    // Chinese
    KUNG_PAO_CHICKEN("깐풍기", CuisineType.CHINESE),
    STIR_FRIED_NOODLES("볶음면", CuisineType.CHINESE),
    SWEET_AND_SOUR_PORK("동파육", CuisineType.CHINESE),
    JAJANGMYEON("짜장면", CuisineType.CHINESE),
    JJAMPPONG("짬뽕", CuisineType.CHINESE),
    MAPO_TOFU("마파두부", CuisineType.CHINESE),
    TANGSUYUK("탕수육", CuisineType.CHINESE),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", CuisineType.CHINESE),
    PEPPER_JAPCHAE("고추잡채", CuisineType.CHINESE),
    // Asian
    PAD_THAI("팟타이", CuisineType.ASIAN),
    KAO_PAD("카오 팟", CuisineType.ASIAN),
    NASI_GORENG("나시고렝", CuisineType.ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", CuisineType.ASIAN),
    PHO("쌀국수", CuisineType.ASIAN),
    TOM_YUM_KUNG("똠얌꿍", CuisineType.ASIAN),
    BANH_MI("반미", CuisineType.ASIAN),
    SUMMER_ROLLS("월남쌈", CuisineType.ASIAN),
    KHMER_NOODLE("분짜", CuisineType.ASIAN),
    // Western
    LASAGNA("라자냐", CuisineType.WESTERN),
    GRATIN("그라탱", CuisineType.WESTERN),
    NYOKKI("뇨끼", CuisineType.WESTERN),
    QUICHE("끼슈", CuisineType.WESTERN),
    FRENCH_TOAST("프렌치 토스트", CuisineType.WESTERN),
    BAGUETTE("바게트", CuisineType.WESTERN),
    SPAGHETTI("스파게티", CuisineType.WESTERN),
    PIZZA("피자", CuisineType.WESTERN),
    PANINI("파니니", CuisineType.WESTERN);

    private final String name;
    private final CuisineType cuisineType;

    Menu(String name, CuisineType cuisineType) {
        this.name = name;
        this.cuisineType = cuisineType;
    }

    public String getName() {
        return name;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }
}
