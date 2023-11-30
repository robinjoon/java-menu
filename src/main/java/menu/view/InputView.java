package menu.view;

import static menu.constants.ErrorMessage.CONTAINS_WHITESPACE;
import static menu.constants.ErrorMessage.END_WITH_DELIMITER;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_FORMAT;
import static menu.constants.ErrorMessage.formatErrorWithRetry;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import menu.domain.Coach;

public class InputView {
    private static final String WHITESPACE_REGEX = "\\s";
    private static final String COMMA_DELIMITER = ",";

    public Coach readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        while(true) {
            try {
                String input = Console.readLine();
                validateNames(input);
                return new Coach(List.of(input.split(COMMA_DELIMITER)));
            } catch(IllegalArgumentException e) {
                System.out.println(formatErrorWithRetry(INVALID_COACH_NAME_FORMAT));
            }
        }
    }

    private void validateNames(String input) {
        validateNotBlank(input);
        validateNotEndWithDelimiter(input);
    }

    private void validateNotBlank(String input) {
        if (input == null || input.isBlank() || containsWhitespace(input)) {
            throw new IllegalArgumentException(formatErrorWithRetry(CONTAINS_WHITESPACE));
        }
    }

    private boolean containsWhitespace(String input) {
        Pattern pattern = Pattern.compile(WHITESPACE_REGEX);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private void validateNotEndWithDelimiter(String input) {
        if (input.endsWith(COMMA_DELIMITER)) {
            throw new IllegalArgumentException(formatErrorWithRetry(END_WITH_DELIMITER));
        }
    }
}
