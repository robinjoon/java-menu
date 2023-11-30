package menu.domain.coach;

import static menu.constants.ErrorMessage.CONTAINS_WHITESPACE;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_LENGTH;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_MAXIMUM_SIZE;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_MINIMUM_SIZE;
import static menu.constants.ErrorMessage.formatErrorWithRetry;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoachNames {
    private final List<String> names;
    private static final String WHITESPACE_REGEX = "\\s";

    public CoachNames(List<String> names) {
        this.names = names;
        validate(names);
    }

    private void validate(List<String> names) {
        validateSize(names);
        for (String name : names) {
            validateEach(name);
        }
    }

    private void validateSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_COACH_NAME_MINIMUM_SIZE));
        }
        if (names.size() > 5) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_COACH_NAME_MAXIMUM_SIZE));
        }
    }

    private void validateEach(String name) {
        validateNotBlank(name);
        validateLength(name);
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

    private void validateLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_COACH_NAME_LENGTH));
        }
    }

    public List<String> getNames() {
        return names;
    }
}

