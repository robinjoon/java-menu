package menu.domain;

import static menu.domain.Category.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISOSIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSUDON("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HAYASHIRICE("하이라이스", JAPANESE),
    RAMEN("라면", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),
    KIMBAP("김밥", KOREAN),
    KIMCHI_SOUP("김치찌개", KOREAN),
    SSAMBAP("쌈밥", KOREAN),
    SOYBEAN_PASTE_SOUP("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    STIR_FRIED_PORK("제육볶음", KOREAN),
    KKANPUNGI("깐풍기", CHINESE),
    FRIED_NOODLES("볶음면", CHINESE),
    DONGPO_MEAT("동파육", CHINESE),
    JAJANGMYEON("짜장면", CHINESE),
    JAMPPONG("짬뽕", CHINESE),
    MAPO_TOFU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    STIR_FRIED_TOMATO_AND_EGG("토마토 달걀볶음", CHINESE),
    RED_PEPPER_JAPCHAE("고추잡채", CHINESE),
    PAD_THAI("팟타이", ASIAN),
    KHAO_PAD("카오 팟", ASIAN),
    NASI_GORENG("나시고랭", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    RICE_NOODLE_SOUP("쌀국수", ASIAN),
    TOM_YUM_GOONG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    WOLLAMSSAM("월남쌈", ASIAN),
    BUN_CHA("분짜", ASIAN),
    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탕", WESTERN),
    GNOCCHI("뇨끼", WESTERN),
    QUICHE("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN);

    private String name;
    private Category category;

    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static boolean contains(String name) {
        return Arrays.stream(Menu.values())
                .anyMatch(menu -> menu.name.equals(name));
    }

    public static Menu called(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static List<String> getMenuNamesByCategory(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory() == category)
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }
}
