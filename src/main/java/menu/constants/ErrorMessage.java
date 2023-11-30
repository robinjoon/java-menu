package menu.constants;

public class ErrorMessage {
    public static final String CONTAINS_WHITESPACE = "공백이 포함되어 있습니다.";
    public static final String INVALID_COACH_NAME_FORMAT = "형식에 맞춰 다시 입력해 주세요.";
    public static final String END_WITH_DELIMITER = "구분자(,)로 끝날 수 없습니다.";
    public static final String INVALID_COACH_NAME_MINIMUM_SIZE = "코치는 최소 2명 이상 입력해야 합니다.";
    public static final String INVALID_COACH_NAME_MAXIMUM_SIZE = "코치는 최대 5명 이하로 입력해야 합니다.";
    public static final String INVALID_COACH_NAME_LENGTH = "코치 이름은 최소 2글자, 최대 4글자로 입력해야 합니다.";
    public static String formatErrorWithRetry(String error) {
        return "[ERROR] " + error ;
    }
}
