package menu.recommend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.coach.Coach;
import menu.menu.Menu;
import menu.menu.MenuType;

public class Recommend {
    private final List<MenuType> menuTypes;
    private final Map<Coach, List<Menu>> recommendMenus;

    public Recommend() {
        this.menuTypes = new ArrayList<>();
        this.recommendMenus = new HashMap<>();
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
    }
}
