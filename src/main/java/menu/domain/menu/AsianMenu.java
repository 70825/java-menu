package menu.domain.menu;

public enum AsianMenu implements Menu {
    PAD_THAI("팟타이"),
    KHAO_PAD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    PHO("쌀국수"),
    TOM_YUM_KUNG("똠얌꿍"),
    BANH_MI("반미"),
    GOI_CUON("월남쌈"),
    BUN_CHA("분짜");

    private final String name;

    AsianMenu(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }
}
