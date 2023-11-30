package menu.view;

import static menu.constants.ErrorMessage.CONTAINS_WHITESPACE;
import static menu.constants.ErrorMessage.END_WITH_DELIMITER;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_FORMAT;
import static menu.constants.ErrorMessage.formatErrorWithRetry;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import menu.domain.Menu;
import menu.domain.coach.CoachNames;
import menu.domain.coach.DislikeMenus;

public class InputView {
    private static final String WHITESPACE_REGEX = "\\s";
    private static final String COMMA_DELIMITER = ",";

    public CoachNames readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        while(true) {
            try {
                String input = Console.readLine();
                validateNames(input);
                return new CoachNames(List.of(input.split(COMMA_DELIMITER)));
            } catch(IllegalArgumentException e) {
                System.out.println(formatErrorWithRetry(INVALID_COACH_NAME_FORMAT));
            }
        }
    }

    private void validateNames(String input) {
        validateNotBlank(input);
        validateNotEndWithDelimiter(input);
    }

    public DislikeMenus readDislikeMenus(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        while(true) {
            try {
                String input = Console.readLine();
                validateDislikeMenus(input);
                return createDislikeMenus(List.of(input.split(COMMA_DELIMITER)));
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateDislikeMenus(String input) {
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

    private DislikeMenus createDislikeMenus(List<String> dislikes) {
        List<Menu> dislikeMenus = new ArrayList<>();
        for(String dislike : dislikes) {
            dislikeMenus.add(Menu.called(dislike));
        }
        return new DislikeMenus(dislikeMenus);
    }
}
