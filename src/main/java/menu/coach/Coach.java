package menu.coach;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import menu.menu.Menu;
import menu.menu.MenuGenerator;
import menu.menu.MenuType;

public class Coach {
    private String name;
    private List<Menu> hateMenus;

    public Coach(String name, String... menus) {
        List<String> menuList = Arrays.asList(menus);
        this.name = name;
        Map<MenuType, List<Menu>> menuBoard = MenuGenerator.menuBoard();
        List<Menu> collect = menuBoard.values().stream()
                .flatMap(Collection::stream)
                .filter(menu -> menuList.contains(menu.getName()))
                .toList();
        if (collect.size() != menus.length) {
            throw new IllegalArgumentException("[ERROR] 없는 메뉴를 못 먹는 음식으로 입력할 수 없습니다.");
        }
    }
}
