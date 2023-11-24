package menu.model.food;

import static menu.model.food.FoodCategory.아시안;
import static menu.model.food.FoodCategory.양식;
import static menu.model.food.FoodCategory.일식;
import static menu.model.food.FoodCategory.중식;
import static menu.model.food.FoodCategory.한식;

public enum Food {

    // 일식
    규동("규동", 일식, 1),
    우동("우동", 일식, 1),
    미소시루("미소시루", 일식, 1),
    스시("스시", 일식, 1),
    가츠동("가츠동", 일식, 1),
    오니기리("오니기리", 일식, 1),
    하이라이스("하이라이스", 일식, 1),
    라멘("라멘", 일식, 1),
    오코노미야끼("오코노미야끼", 일식, 1),

    // 한식
    김밥("김밥", 한식, 2),
    김치찌개("김치찌개", 한식, 2),
    쌈밥("쌈밥", 한식, 2),
    된장찌개("된장찌개", 한식, 2),
    비빔밥("비빔밥", 한식, 2),
    칼국수("칼국수", 한식, 2),
    불고기("불고기", 한식, 2),
    떡볶이("떡볶이", 한식, 2),
    제육볶음("제육볶음", 한식, 2),

    // 중식
    깐풍기("깐풍기", 중식, 3),
    볶음면("볶음면", 중식, 3),
    동파육("동파육", 중식, 3),
    짜장면("짜장면", 중식, 3),
    짬뽕("짬뽕", 중식, 3),
    마파두부("마파두부", 중식, 3),
    탕수육("탕수육", 중식, 3),
    토마토_달걀볶음("토마토 달걀볶음", 중식, 3),
    고추잡채("고추잡채", 중식, 3),

    // 아시안
    팟타이("팟타이", 아시안, 4),
    카오_팟("카오 팟", 아시안, 4),
    나시고렝("나시고렝", 아시안, 4),
    파인애플_볶음밥("파인애플 볶음밥", 아시안, 4),
    쌀국수("쌀국수", 아시안, 4),
    똠얌꿍("똠얌꿍", 아시안, 4),
    반미("반미", 아시안, 4),
    월남쌈("월남쌈", 아시안, 4),
    분짜("분짜", 아시안, 4),

    // 양식
    라자냐("라자냐", 양식, 5),
    그라탱("그라탱", 양식, 5),
    뇨끼("뇨끼", 양식, 5),
    끼슈("끼슈", 양식, 5),
    프렌치_토스트("프렌치 토스트", 양식, 5),
    바게트("바게트", 양식, 5),
    스파게티("스파게티", 양식, 5),
    피자("피자", 양식, 5),
    파니니("파니니", 양식, 5);


    private final String name;
    private final FoodCategory FoodCategory;
    private final Integer foodCategoryNumber;

    Food(String name, menu.model.food.FoodCategory foodCategory, Integer foodCategoryNumber) {
        this.name = name;
        FoodCategory = foodCategory;
        this.foodCategoryNumber = foodCategoryNumber;
    }
}
