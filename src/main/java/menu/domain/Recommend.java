package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recommend {
    private final List<MenuType> menuTypes;
    private final Map<Coach, List<Menu>> recommendMenus;

    public Recommend(Coaches coaches) {
        this.menuTypes = new ArrayList<>();
        this.recommendMenus = new LinkedHashMap<>();
        for (Coach coach : coaches.getCoaches()) {
            recommendMenus.put(coach, new ArrayList<>());
        }
    }

    public void selectNextMenuType(int menuTypeNumber) {
        MenuType selectedMenuType = Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.getCode() == menuTypeNumber)
                .findFirst().orElseThrow();
        long beforeSelectedCount = menuTypes.stream().filter(menuType -> menuType == selectedMenuType)
                .count();
        if (beforeSelectedCount > 2) {
            throw new RuntimeException("다른 카테고리 설정 필요");
        }
        menuTypes.add(selectedMenuType);
    }

    public void selectMenu() {
        recommendMenus.keySet().forEach(this::selectMenu);
    }

    private void selectMenu(Coach coach) {
        MenuType menuType = menuTypes.get(menuTypes.size() - 1);
        Map<MenuType, List<Menu>> menuBoard = MenuGenerator.menuBoard();
        List<String> menus = menuBoard.get(menuType).stream().map(Menu::getName).collect(Collectors.toList());
        List<String> hateMenus = coach.getHateMenus().stream().map(Menu::getName).collect(Collectors.toList());
        List<String> preSelectedMenus = recommendMenus.get(coach).stream().map(Menu::getName)
                .collect(Collectors.toList());
        String selectedMenuName = Randoms.shuffle(menus).get(0);
        while (preSelectedMenus.contains(selectedMenuName) || hateMenus.contains(selectedMenuName)) {
            selectedMenuName = Randoms.shuffle(menus).get(0);
        }
        String finalSelectedMenuName = selectedMenuName;
        Menu selectedMenu = menuBoard.get(menuType).stream()
                .filter(menu -> menu.getName().equals(finalSelectedMenuName))
                .findFirst().orElseThrow();
        recommendMenus.get(coach).add(selectedMenu);
    }

    List<MenuType> getMenuTypes() {
        return menuTypes;
    }

    Map<Coach, List<Menu>> getRecommendMenus() {
        return recommendMenus;
    }
}
