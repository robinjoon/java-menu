package menu.domain;

enum MenuType {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);
    private final String displayName;
    private final int code;

    MenuType(String displayName, int code) {
        this.displayName = displayName;
        this.code = code;
    }

    int getCode() {
        return code;
    }

    String getDisplayName() {
        return displayName;
    }
}

