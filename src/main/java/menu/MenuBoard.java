package menu;

import java.util.*;

public class MenuBoard {

    private final static List<String> menuCategory = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
    private final static List<String> japaneseMenu = Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    private final static List<String> koreanMenu = Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    private final static List<String> chaineseMenu = Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토", "달걀볶음", "고추잡채");
    private final static List<String> asianMenu = Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    private final static List<String> westernMenu = Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");

    private final static List<List<String>> menus = new ArrayList<>();

    static {
        menus.add(japaneseMenu);
        menus.add(koreanMenu);
        menus.add(chaineseMenu);
        menus.add(asianMenu);
        menus.add(westernMenu);
    }

    public static List<List<String>> getMenus() {
        return menus;
    }

    public static List<String> getMenuCategory() {
        return menuCategory;
    }
}
