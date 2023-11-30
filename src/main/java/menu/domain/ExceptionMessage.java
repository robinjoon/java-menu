package menu.domain;

public class ExceptionMessage {
    public static final String CONTINUITY_SEPARATOR = "[ERROR] 구분자를 연속해서 입력할 수 없습니다.";
    public static final String INVALID_COACH_NAME_LENGTH = "[ERROR] 코치이름은 2글자 이상 4글자 이하여야 합니다.";
    public static final String COACH_NAME_BLANK = "[ERROR] 코치이름은 공백이 포함될 수 없습니다.";
    public static final String DUPLICATE_COACH_NAME = "[ERROR] 코치이름은 중복될 수 없습니다.";
    public static final String INVALID_COACH_COUNT = "[ERROR] 코치는 최소 2명, 최대 5명 입력할 수 있습니다.";
    public static final String INVALID_HATE_MENU_COUNT = "[ERROR] 코치가 못 먹는 음식은 0개 이상 2개 이하여야 합니다.";
    public static final String HATE_MENU_NOT_CONTAIN_MENU_BOARD = "[ERROR] 없는 메뉴를 못 먹는 음식으로 입력할 수 없습니다.";
    public static final String HATE_MENU_INPUT_BLANK_AND_NAME = "[ERROR] 못 먹는 메뉴 입력에 공백과 메뉴가 동시에 포함될 수 없습니다.";

    public static final String DUPLICATE_MENU_TYPE = "다른 카테고리 설정 필요";
}
