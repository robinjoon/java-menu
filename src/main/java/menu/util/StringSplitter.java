package menu.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public final class StringSplitter<T> {
    private final Set<PredicateWithExceptionMessage<String>> afterSplitConditions;
    private final Set<PredicateWithExceptionMessage<String>> beforeSplitConditions;
    private final String regex;


    public StringSplitter(String regex) {
        afterSplitConditions = new HashSet<>();
        beforeSplitConditions = new HashSet<>();
        this.regex = regex;
    }

    public void addBeforeSplitCondition(PredicateWithExceptionMessage<String> beforeSplitCondition) {
        beforeSplitConditions.add(beforeSplitCondition);
    }

    public void addAfterSplitCondition(PredicateWithExceptionMessage<String> afterSplitCondition) {
        afterSplitConditions.add(afterSplitCondition);
    }

    public List<T> split(final String input, final Function<String, T> mapper) {
        checkAllBeforeSplitConditionsTrue(input);
        String[] split = input.split(regex);
        checkAllAfterSplitConditionsTrue(split);
        return Arrays.stream(split).map(mapper).toList();
    }

    private void checkAllAfterSplitConditionsTrue(String[] split) {
        for (PredicateWithExceptionMessage<String> predicateWithExceptionMessage : afterSplitConditions) {
            Predicate<String> predicate = predicateWithExceptionMessage.predicate();
            String errorMessage = predicateWithExceptionMessage.errorMessage();
            boolean allMatch = Arrays.stream(split).allMatch(predicate);
            if (!allMatch) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    private void checkAllBeforeSplitConditionsTrue(String input) {
        for (PredicateWithExceptionMessage<String> predicateWithExceptionMessage : beforeSplitConditions) {
            Predicate<String> predicate = predicateWithExceptionMessage.predicate();
            String errorMessage = predicateWithExceptionMessage.errorMessage();
            boolean allMatch = predicate.test(input);
            if (!allMatch) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
