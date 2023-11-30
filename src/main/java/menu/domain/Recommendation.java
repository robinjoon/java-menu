package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class Recommendation {
    Map<Category, Integer> categoryCount;

    public Recommendation() {
    }

    public void start() {
        for (int i = 0; i < 5; i++) {
            selectCategory();

        }
    }

    private void selectCategory() {
        Category category = pickRandomCategory();
        int currentCount = categoryCount.get(category);

        while (currentCount >= 2) {
            category = pickRandomCategory();
            currentCount = categoryCount.get(category);
        }

        categoryCount.put(category, currentCount + 1);
    }

    private Category pickRandomCategory() {
        return Category.get(Randoms.pickNumberInRange(1,5));
    }
}
