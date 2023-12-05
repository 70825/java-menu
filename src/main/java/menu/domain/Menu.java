package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static final List<String> JAPANESE =
            new ArrayList<>(Arrays.asList("규동", "우동", "미소시루",
                    "스시", "가츠동","오니기리", "하이라이스", "라멘", "오꼬노미야끼"));
    private static final List<String> KOREAN =
            new ArrayList<>(Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기",
                    "떡볶이","제육볶음"));

    private static final List<String> CHINESE =
            new ArrayList<>(Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육",
                    "토마토 ","달걀볶음","고추잡채"));

    private static final List<String> ASIAN =
            new ArrayList<>(Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "똠얌꿍", "반미", "월남쌈",
                    "분짜"));

    private static final List<String> WESTERN =
            new ArrayList<>(Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티",
                    "피자","파니니"));


    public void Recommend(List<MenuCategory> category, List<String> coachNames) {
        for(MenuCategory categoryName : category){
            categoryCheck(categoryName);
        }
    }

    private String categoryCheck(MenuCategory categoryName) {
        if(categoryName.equals(MenuCategory.JAPANESE)){
            return Randoms.shuffle(JAPANESE).get(0);
        }
        if(categoryName.equals(MenuCategory.KOREAN)){
            return Randoms.shuffle(KOREAN).get(0);
        }
        if(categoryName.equals(MenuCategory.CHINESE)){
            return Randoms.shuffle(CHINESE).get(0);
        }
        if(categoryName.equals(MenuCategory.ASIAN)){
            return Randoms.shuffle(ASIAN).get(0);
        }
        if(categoryName.equals(MenuCategory.WESTERN)){
            return Randoms.shuffle(WESTERN).get(0);
        }
        throw new IllegalArgumentException();
    }
}
