package menu.domain;

import static menu.domain.ExceptionMessage.COACH_NAME_BLANK;
import static menu.domain.ExceptionMessage.HATE_MENU_INPUT_BLANK_AND_NAME;
import static menu.domain.ExceptionMessage.HATE_MENU_NOT_CONTAIN_MENU_BOARD;
import static menu.domain.ExceptionMessage.INVALID_COACH_NAME_LENGTH;
import static menu.domain.ExceptionMessage.INVALID_HATE_MENU_COUNT;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Coach {
    private String name;
    private List<Menu> hateMenus;

    Coach(String name, String... hateMenus) {
        validateName(name);
        validateHateMenuCount(hateMenus);
        setHateMenus(name, hateMenus);
    }

    private void setHateMenus(String name, String[] hateMenus) {
        List<String> hateMenuNames = Arrays.asList(hateMenus);
        if (hateMenuIsEmpty(name, hateMenuNames)) {
            return;
        }
        validateHateMenusNotContainBlankAndOther(hateMenuNames);
        this.name = name;
        Map<MenuType, List<Menu>> menuBoard = MenuGenerator.menuBoard();
        List<Menu> hateMenusInMenuBoard = menuBoard.values().stream()
                .flatMap(Collection::stream)
                .filter(menu -> hateMenuNames.contains(menu.getName()))
                .toList();
        validateHateMenusNotContainInvalidMenu(hateMenusInMenuBoard, hateMenus);
        this.hateMenus = hateMenusInMenuBoard;
    }

    private boolean hateMenuIsEmpty(String name, List<String> hateMenuNames) {
        if (hateMenuNames.isEmpty() || (hateMenuNames.size() == 1 && hateMenuNames.get(0).isBlank())) {
            this.name = name;
            this.hateMenus = Collections.emptyList();
            return true;
        }
        return false;
    }

    private static void validateHateMenusNotContainBlankAndOther(List<String> hateMenuNames) {
        if ((hateMenuNames.contains("") || hateMenuNames.contains(" ")) && hateMenuNames.size() > 1) {
            throw new IllegalArgumentException(HATE_MENU_INPUT_BLANK_AND_NAME);
        }
    }

    private static void validateHateMenusNotContainInvalidMenu(List<Menu> collect, String[] hateMenus) {
        if (collect.size() != hateMenus.length) {
            throw new IllegalArgumentException(HATE_MENU_NOT_CONTAIN_MENU_BOARD);
        }
    }

    private static void validateName(String name) {
        validateNameLength(name);
        validateNameNotContainBlank(name);
    }

    private static void validateNameNotContainBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(COACH_NAME_BLANK);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH);
        }
    }

    private static void validateHateMenuCount(String[] menus) {
        if (menus.length > 2) {
            throw new IllegalArgumentException(INVALID_HATE_MENU_COUNT);
        }
    }

    List<Menu> getHateMenus() {
        return hateMenus;
    }

    String getName() {
        return name;
    }
}
