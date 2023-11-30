package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.view.InputManger;
import menu.view.OutputView;

public class RecommendController {
    public static void start(){
        OutputView.recommendMenuStart();
        Coaches coaches = new Coaches(InputManger.inputCoachName());
        printOption();
        recommendMenu(coaches);
        coaches.getCoaches().forEach(System.out::println);
        OutputView.recommendFinish();
    }
    private static void printOption(){
        OutputView.printResult();
        OutputView.printGubn();
        OutputView.printCategory(Week.getInstance().toString());
    }
    private static void recommendMenu(Coaches coaches){
        Week.getInstance().getCategories().forEach(category->{
            recommend(category,coaches);
        });
    }

    private static void recommend(Menu category, Coaches coaches){
        coaches.getCoaches().stream().forEach(coach -> {
            coach.setRecommendedMenu(category);
        });
    }
}
