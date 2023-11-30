package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> pickyEating = new ArrayList<>();

    private final List<String> recommendedMenu = new ArrayList<>();

    Coach(String name, String pickyEating) {
        this.name = name;
        this.pickyEating.addAll(Arrays.asList(pickyEating.split(",")));
    }

    public void setRecommendedMenu(Menu category) {
        String menuName = Menu.getMenu(category);
        while (pickyEating.contains(menuName) || recommendedMenu.contains(menuName)) {
            menuName = Menu.getMenu(category);
        }
        recommendedMenu.add(menuName);
    }


    private String getRecommend() {
        StringBuilder sb = new StringBuilder();
        for (String menu : recommendedMenu) {
            sb.append("| %s ".formatted(menu));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "[ %s %s]".formatted(this.name, getRecommend());
    }
}
