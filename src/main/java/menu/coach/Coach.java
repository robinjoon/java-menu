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

    public Coach(String name, String... hateMenus) {
        validateNameLength(name);
        validateHateMenuCount(hateMenus);
        List<String> hateMenuNames = Arrays.asList(hateMenus);
        validateHateMenusNotContainBlankAndOther(hateMenuNames);
        this.name = name;
        Map<MenuType, List<Menu>> menuBoard = MenuGenerator.menuBoard();
        List<Menu> collect = menuBoard.values().stream()
                .flatMap(Collection::stream)
                .filter(menu -> hateMenuNames.contains(menu.getName()))
                .toList();
        validateHateMenusNotContainInvalidMenu(collect, hateMenus);
        this.hateMenus = collect;
    }

    private static void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 코치이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    private static void validateHateMenusNotContainBlankAndOther(List<String> hateMenuNames) {
        if ((hateMenuNames.contains("") || hateMenuNames.contains(" ")) && hateMenuNames.size() > 1) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴 입력에 공백과 메뉴가 동시에 포함될 수 없습니다.");
        }
    }

    private static void validateHateMenusNotContainInvalidMenu(List<Menu> collect, String[] hateMenus) {
        if (collect.size() != hateMenus.length) {
            throw new IllegalArgumentException("[ERROR] 없는 메뉴를 못 먹는 음식으로 입력할 수 없습니다.");
        }
    }

    private static void validateHateMenuCount(String[] menus) {
        if (menus.length > 2) {
            throw new IllegalArgumentException("[ERROR] 코치가 못 먹는 음식은 0개 이상 2개 이하여야 합니다.");
        }
    }
}
