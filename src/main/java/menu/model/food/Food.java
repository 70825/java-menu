package menu.model.food;

import static menu.model.food.FoodCategory.아시안;
import static menu.model.food.FoodCategory.양식;
import static menu.model.food.FoodCategory.일식;
import static menu.model.food.FoodCategory.중식;
import static menu.model.food.FoodCategory.한식;

public enum Food {

    // 일식
    규동("규동", 일식),
    우동("우동", 일식),
    미소시루("미소시루", 일식),
    스시("스시", 일식),
    가츠동("가츠동", 일식),
    오니기리("오니기리", 일식),
    하이라이스("하이라이스", 일식),
    라멘("라멘", 일식),
    오코노미야끼("오코노미야끼", 일식),

    // 한식
    김밥("김밥", 한식),
    김치찌개("김치찌개", 한식),
    쌈밥("쌈밥", 한식),
    된장찌개("된장찌개", 한식),
    비빔밥("비빔밥", 한식),
    칼국수("칼국수", 한식),
    불고기("불고기", 한식),
    떡볶이("떡볶이", 한식),
    제육볶음("제육볶음", 한식),

    // 중식
    깐풍기("깐풍기", 중식),
    볶음면("볶음면", 중식),
    동파육("동파육", 중식),
    짜장면("짜장면", 중식),
    짬뽕("짬뽕", 중식),
    마파두부("마파두부", 중식),
    탕수육("탕수육", 중식),
    토마토_달걀볶음("토마토 달걀볶음", 중식),
    고추잡채("고추잡채", 중식),

    // 아시안
    팟타이("팟타이", 아시안),
    카오_팟("카오 팟", 아시안),
    나시고렝("나시고렝", 아시안),
    파인애플_볶음밥("파인애플 볶음밥", 아시안),
    쌀국수("쌀국수", 아시안),
    똠얌꿍("똠얌꿍", 아시안),
    반미("반미", 아시안),
    월남쌈("월남쌈", 아시안),
    분짜("분짜", 아시안),

    // 양식
    라자냐("라자냐", 양식),
    그라탱("그라탱", 양식),
    뇨끼("뇨끼", 양식),
    끼슈("끼슈", 양식),
    프렌치_토스트("프렌치 토스트", 양식),
    바게트("바게트", 양식),
    스파게티("스파게티", 양식),
    피자("피자", 양식),
    파니니("파니니", 양식);


    private final String name;
    private final FoodCategory FoodCategory;

    Food(String name, menu.model.food.FoodCategory foodCategory) {
        this.name = name;
        FoodCategory = foodCategory;
    }
}
