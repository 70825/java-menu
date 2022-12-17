package menu.service;

import menu.domain.Foods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitService {

    public void init() {
        addFoods("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        addFoods("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        addFoods("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        addFoods("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        addFoods("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }

    private List<String> preprocessFood(String value) {
        return Arrays.stream(value.split(", ")).collect(Collectors.toList());
    }

    private void addFoods(String value) {
        List<String> foodList = preprocessFood(value);
        foodList.forEach(Foods::addFood);
    }
}
