package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Week {
    private static Week week;
    private static final List<Menu> Categories = new ArrayList<>();
    private static int size = 5;
    private static int sameCategory = 2;
    private Week() {
        while (Categories.size() < size) {
            Menu category = Menu.getCategory(Randoms.pickNumberInRange(1, 5));
            int count = Collections.frequency(Categories, category);
            if (count > sameCategory-1) {
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
        return this.Categories;
    }
    private String getCategoryOfDay(){
        StringBuilder sb = new StringBuilder();
        Categories.stream().forEach(category->{
            sb.append(" | ");
            sb.append(category.getCategoryName() );
        });
        return sb.toString();
    }
    @Override
    public String toString(){
        return "[ 카테고리%s ]".formatted(getCategoryOfDay());
    }
}
