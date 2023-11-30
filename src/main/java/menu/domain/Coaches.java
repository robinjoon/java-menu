package menu.domain;

import static menu.domain.ExceptionMessage.CONTINUITY_SEPARATOR;
import static menu.domain.ExceptionMessage.DUPLICATE_COACH_NAME;
import static menu.domain.ExceptionMessage.INVALID_COACH_COUNT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.PredicateWithExceptionMessage;
import menu.util.StringSplitter;

public class Coaches {
    private final List<Coach> coaches;
    private final List<String> coachNames;

    public Coaches(String coachNames) {
        StringSplitter<String> coachNameSplitter = new StringSplitter<>(",");
        PredicateWithExceptionMessage<String> continuitySeparatorDenied = new PredicateWithExceptionMessage<>(
                s -> !s.contains(",,"), CONTINUITY_SEPARATOR);
        coachNameSplitter.addBeforeSplitCondition(continuitySeparatorDenied);
        List<String> seperatedCoachNames = coachNameSplitter.split(coachNames, s -> s);
        validateDuplicateCoachNames(seperatedCoachNames);
        validateCoachCount(seperatedCoachNames);
        this.coachNames = seperatedCoachNames;
        coaches = new ArrayList<>();
    }

    private static void validateCoachCount(List<String> split) {
        if (split.size() < 2 || split.size() > 5) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT);
        }
    }

    private static void validateDuplicateCoachNames(List<String> split) {
        Set<String> uniqueSplit = new HashSet<>(split);
        if (split.size() != uniqueSplit.size()) {
            throw new IllegalArgumentException(DUPLICATE_COACH_NAME);
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void addHateMenus(String coachName, String hateMenus) {
        coaches.add(new Coach(coachName, hateMenus));
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
