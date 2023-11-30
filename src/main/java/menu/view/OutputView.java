package menu.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import menu.domain.menu.Category;
import menu.domain.menu.Menu;
import menu.domain.menu.Recommendation;

public class OutputView {
    public void printResult(Recommendation recommendation) {
        System.out.println("메뉴 추천 결과입니다.");
        printDaysOfWeek();
        printCategories(recommendation.getCategories());
        printMenus(recommendation.getRecommendedMenu());
    }

    private void printDaysOfWeek() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 구분");

        List<String> daysOfWeek = Arrays.asList("월요일", "화요일", "수요일", "목요일", "금요일");
        for (String day : daysOfWeek) {
            stringBuilder.append(" | ").append(day);
        }

        stringBuilder.append(" ]");
        System.out.println(stringBuilder);
    }

    private void printCategories(List<Category> categories) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 카테고리");

        for (Category category : categories) {
            stringBuilder.append(" | ").append(category.getName());
        }

        stringBuilder.append(" ]");
        System.out.println(stringBuilder);
    }

    private void printMenus(Map<String, List<Menu>> recommended) {
        recommended.forEach((coachName, menus) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[ ").append(coachName).append("");

            for (Menu menu : menus) {
                stringBuilder.append(" | ").append(menu.getName());
            }

            stringBuilder.append(" ]");
            System.out.println(stringBuilder);
        });
    }
}
