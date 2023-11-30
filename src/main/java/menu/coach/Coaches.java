package menu.coach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.util.StringSplitter;

public class Coaches {
    private List<Coach> coaches;
    private List<String> coachNames;

    public Coaches(String coachNames) {
        StringSplitter<String> coachNameSplitter = new StringSplitter<>(",");
        List<String> seperatedCoachNames = coachNameSplitter.split(coachNames, s -> s);
        validateDuplicateCoachNames(seperatedCoachNames);
        validateCoachCount(seperatedCoachNames);
        this.coachNames = seperatedCoachNames;
        coaches = new ArrayList<>();
    }

    private static void validateCoachCount(List<String> split) {
        if (split.size() < 2 || split.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명, 최대 5명 입력할 수 있습니다.");
        }
    }

    private static void validateDuplicateCoachNames(List<String> split) {
        Set<String> uniqueSplit = new HashSet<>(split);
        if (split.size() != uniqueSplit.size()) {
            throw new IllegalArgumentException("[ERROR] 코치이름은 중복될 수 없습니다.");
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
