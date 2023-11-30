package menu;

import java.util.ArrayList;
import java.util.List;

import menu.MenuBoard.*;
import camp.nextstep.edu.missionutils.Randoms;

public class MenuGenerator {
    private static List<Integer> randomCategoryNumbers;

    public MenuGenerator() {
        randomCategoryNumbers = generateCategoryNumber();
    }

    public List<String> generateMenusForEachCoach(Coach coach) {
        List<String> randomMenus = new ArrayList<>();
        int i = 0;
        while (randomMenus.size() < 5) {
            String menu = generateDailyMenu(MenuBoard.getMenus()
                    .get(
                            randomCategoryNumbers.get(i)-1
                    ));
            if (coach.notEatableFood().contains(menu) || randomMenus.contains(menu)) {
                System.out.println(menu);
                continue;
            }
            randomMenus.add(menu);
            i++;
        }
        return randomMenus;
    }

    private static List<Integer> generateCategoryNumber() {
        List<Integer> randomCategories = new ArrayList<>();
        int i = 0;
        while (randomCategories.size() < 5) {
            Integer categoryNumber = Randoms.pickNumberInRange(1, 5);
            if (randomCategories.contains(categoryNumber)) {
                continue;
            }
            randomCategories.add(categoryNumber);
            i++;
        }
        return randomCategories;
    }

    private static String generateDailyMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    public List<String> getRandomCategory() {
        return randomCategoryNumbers.stream().map(num -> MenuBoard.getMenuCategory().get(num - 1)).toList();
    }
}

