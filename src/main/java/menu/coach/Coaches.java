package menu.coach;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import menu.util.StringSplitter;

public class Coaches {
    private List<Coach> coaches;
    private Map<String, List<String>> coachNameAndHateMenus;

    public Coaches(String coachNames) {
        StringSplitter<String> coachNameSplitter = new StringSplitter<>(",");
        List<String> split = coachNameSplitter.split(coachNames, s -> s);
        validateDuplicateCoachNames(split);
    }

    private static void validateDuplicateCoachNames(List<String> split) {
        Set<String> uniqueSplit = new HashSet<>(split);
        if (split.size() != uniqueSplit.size()) {
            throw new IllegalArgumentException("[ERROR] 코치이름은 중복될 수 없습니다.");
        }
    }
}
