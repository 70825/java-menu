package menu.domain.menu;

public enum ChineseMenu implements Menu {
    KANPOONGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPA_YUK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    TANGSU_YUK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    GOCHEU_JAPCHAE("고추잡채");

    private final String name;

    ChineseMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
