package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.coach.Coach;

public class Recommendation {
    Map<Category, Integer> categoryCount;
    Map<Coach, List<Menu>> recommendedMenu;

    public void start(List<Coach> coaches) {
        initRecommendedMenu(coaches);
        for (int i = 0; i < 5; i++) {
            Category category = selectCategory();
            for(Coach coach : coaches) {
                Menu menu = selectMenu(coach, category);
                if(recommendedMenu.get(coach).contains(menu)) {
                    menu = selectMenu(coach, category);
                }
                recommendedMenu.get(coach).add(menu);
            }
        }
    }

    private Category selectCategory() {
        Category category = pickRandomCategory();
        int currentCount = categoryCount.get(category);

        while (currentCount >= 2) {
            category = pickRandomCategory();
            currentCount = categoryCount.get(category);
        }

        categoryCount.put(category, currentCount + 1);
        return category;
    }

    private Category pickRandomCategory() {
        return Category.get(Randoms.pickNumberInRange(1,5));
    }

    private String pickRandomMenu(Category category) {
        return Randoms.shuffle(Menu.getMenuNamesByCategory(category)).get(0);
    }

    private Menu selectMenu(Coach coach, Category category) {
        Menu menu = Menu.called(pickRandomMenu(category));
        while(coach.isDislike(menu)) {
            menu = Menu.called(pickRandomMenu(category));
        }
        return menu;
    }

    private void initRecommendedMenu(List<Coach> coaches) {
        coaches.forEach(coach -> {
            recommendedMenu.put(coach, new ArrayList<>());
        });
    }
}
