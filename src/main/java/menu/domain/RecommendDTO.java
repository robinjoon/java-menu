package menu.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecommendDTO {
    private final List<String> menuTypes;
    private final Map<String, List<String>> recommendMenus;

    public RecommendDTO(Recommend recommend) {
        menuTypes = recommend.getMenuTypes().stream().map(MenuType::getDisplayName).toList();
        recommendMenus = new LinkedHashMap<>();
        Map<Coach, List<Menu>> recommendMenusFromDomain = recommend.getRecommendMenus();
        for (Coach coach : recommendMenusFromDomain.keySet()) {
            List<String> menuNames = recommendMenusFromDomain.get(coach).stream().map(Menu::getName).toList();
            recommendMenus.put(coach.getName(), menuNames);
        }
    }

    public List<String> getMenuTypes() {
        return menuTypes;
    }

    public Map<String, List<String>> getRecommendMenus() {
        return recommendMenus;
    }
}
