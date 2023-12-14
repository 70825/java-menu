package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    GYUDON("규동", MenuCategory.JAPAN),
    UDON("우동", MenuCategory.JAPAN),
    MISOSHIRU("미소시루", MenuCategory.JAPAN),
    SUSHI("스시", MenuCategory.JAPAN),
    KATSUDON("가츠동", MenuCategory.JAPAN),
    ONIGIRI("오니기리", MenuCategory.JAPAN),
    HAYARICE("하이라이스", MenuCategory.JAPAN),
    RAMEN("라멘", MenuCategory.JAPAN),
    OKONOMIYAKI("오코노미야끼", MenuCategory.JAPAN),

    GIMBAP("김밥", MenuCategory.KOREA),
    KIMCHI_STEW("김치찌개", MenuCategory.KOREA),
    SABAL("쌈밥", MenuCategory.KOREA),
    DWENJANG_STEW("된장찌개", MenuCategory.KOREA),
    BIBIMBAP("비빔밥", MenuCategory.KOREA),
    KALGUKSU("칼국수", MenuCategory.KOREA),
    BULGOGI("불고기", MenuCategory.KOREA),
    TTEOKBOKKI("떡볶이", MenuCategory.KOREA),
    JAEYUK_BOKKEUM("제육볶음", MenuCategory.KOREA),

    KANPOONGI("깐풍기", MenuCategory.CHINA),
    STIR_FRIED_NOODLES("볶음면", MenuCategory.CHINA),
    DONGPA_YUK("동파육", MenuCategory.CHINA),
    JAJANGMYEON("짜장면", MenuCategory.CHINA),
    JJAMPPONG("짬뽕", MenuCategory.CHINA),
    MAPA_TOFU("마파두부", MenuCategory.CHINA),
    TANGSU_YUK("탕수육", MenuCategory.CHINA),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음", MenuCategory.CHINA),
    GOCHEU_JAPCHAE("고추잡채", MenuCategory.CHINA),

    PAD_THAI("팟타이", MenuCategory.ASIA),
    KHAO_PAD("카오 팟", MenuCategory.ASIA),
    NASI_GORENG("나시고렝", MenuCategory.ASIA),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", MenuCategory.ASIA),
    PHO("쌀국수", MenuCategory.ASIA),
    TOM_YUM_KUNG("똠얌꿍", MenuCategory.ASIA),
    BANH_MI("반미", MenuCategory.ASIA),
    GOI_CUON("월남쌈", MenuCategory.ASIA),
    BUN_CHA("분짜", MenuCategory.ASIA),

    LASAGNA("라자냐", MenuCategory.WESTERN),
    GRATIN("그라탱", MenuCategory.WESTERN),
    NYOKKI("뇨끼", MenuCategory.WESTERN),
    QUICHE("끼슈", MenuCategory.WESTERN),
    FRENCH_TOAST("프렌치 토스트", MenuCategory.WESTERN),
    BAGUETTE("바게트", MenuCategory.WESTERN),
    SPAGHETTI("스파게티", MenuCategory.WESTERN),
    PIZZA("피자", MenuCategory.WESTERN),
    PANINI("파니니", MenuCategory.WESTERN);


    private String name;
    private MenuCategory category;

    Menu(String name, MenuCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public static Menu findMenu(String name) {
        List<Menu> menus = List.of(Menu.values());

        for (Menu menu : menus) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }

        throw new IllegalArgumentException(ErrorMessage.HATE_MENU_ERROR_MESSAGE);
    }

    public static String choiceMenu(MenuCategory category) {
        List<String> menuNames = Arrays.stream(Menu.values())
                .filter(menu -> menu.category.equals(category))
                .map(Menu::getName)
                .collect(Collectors.toList());

        return Randoms.shuffle(menuNames).get(0);
    }
}
