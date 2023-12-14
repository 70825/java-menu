package menu.domain.menu;

public enum KoreanMenu implements Menu {
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SABAL("쌈밥"),
    DWENJANG_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUK_BOKKEUM("제육볶음");

    private final String name;

    KoreanMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
