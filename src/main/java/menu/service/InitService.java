package menu.service;

import menu.domain.Categories;
import menu.domain.Category;
import menu.domain.Foods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitService {

    public void init() {
        Category one = new Category("일식",
                preprocessFood("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼"));

        Category two = new Category("한식",
                preprocessFood("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음"));

        Category three = new Category("중식",
                preprocessFood("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채"));

        Category four = new Category("아시안",
                preprocessFood("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜"));

        Category five = new Category("양식",
                preprocessFood("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니"));

        Categories.addCategory(one);
        Categories.addCategory(two);
        Categories.addCategory(three);
        Categories.addCategory(five);
        Categories.addCategory(four);

    }

    private List<String> preprocessFood(String value) {
        return Arrays.stream(value.split(", ")).collect(Collectors.toList());
    }
}
