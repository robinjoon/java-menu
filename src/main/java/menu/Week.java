package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week {
    private static Week week;
    private static final List<Menu> Categories = new ArrayList<>();
    private static int size = 5;

    private Week() {
        while (Categories.size() < size) {
            Menu category = Menu.getCategory(Randoms.pickNumberInRange(1, 5));
            int count = Collections.frequency(Categories, category);
            if (count > 2) {
                continue;
            }
            Categories.add(category);
        }
    }

    public static Week getInstance() {
        if (week == null) {
            week = new Week();
        }
        return week;
    }

    public List<Menu> getCategories() {
        getInstance();
        return this.Categories;
    }
}
