package menu.domain.menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.coach.Coach;

public class Recommendation {
    List<Category> categories;
    Map<Category, Integer> categoryCount;
    Map<String, List<Menu>> recommendedMenu;

    public Recommendation() {
        categories = new ArrayList<>();
        recommendedMenu = new HashMap<>();
        categoryCount = new HashMap<>();
    }

    public void start(List<Coach> coaches) {
        init(coaches);
        for (int i = 0; i < 5; i++) {
            Category category = selectCategory();
            categories.add(category);
            for(Coach coach : coaches) {
                String coachName = coach.getName();
                Menu menu = selectMenu(coach, category);
                if(recommendedMenu.get(coachName).contains(menu)) {
                    menu = selectMenu(coach, category);
                }
                recommendedMenu.get(coachName).add(menu);
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

    public List<Category> getCategories() {
        return categories;
    }

    public Map<String, List<Menu>> getRecommendedMenu() {
        return recommendedMenu;
    }

    private void init(List<Coach> coaches) {
        for (Coach coach : coaches) {
            recommendedMenu.put(coach.getName(), new ArrayList<>());
        }
        for (Category category : Category.values()) {
            categoryCount.put(category, 0);
        }
    }
}
