package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);

    private String name;
    private int number;

    Category(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static Category get(int number) {
        return Arrays.stream(Category.values())
                .filter(category -> category.getNumber() == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
