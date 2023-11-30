package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> pickyEating = new ArrayList<>();
    private static final int pickySize = 2;

    private List<String> recommendedMenu = new ArrayList<>();

    Coach(String name, String pickyEating) {
        this.name = name;
        this.pickyEating.addAll(Arrays.asList(pickyEating.split(",")));
//        menuRecommend();
    }

    public void setRecommendedMenu(Menu category) {
        String menuName = Menu.getMenu(category);
        while (pickyEating.contains(menuName)) {
            menuName = Menu.getMenu(category);
        }
        while (recommendedMenu.contains(menuName)) {
            menuName = Menu.getMenu(category);
        }
        recommendedMenu.add(menuName);
    }


    private String getRecommend() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recommendedMenu.size(); i++) {
            sb.append("| %s ".formatted(recommendedMenu.get(i)));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "[ %s %s]".formatted(this.name, getRecommend());
    }
}
