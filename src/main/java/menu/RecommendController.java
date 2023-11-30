package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.view.InputManger;
import menu.view.OutputView;

public class RecommendController {
    public static void start(){
        OutputView.recommendMenuStart();
        String coachNames = InputManger.inputCoachName();
        List<Coach> Coaches = new ArrayList<>();
        Arrays.stream(coachNames.split(",")).forEach(name->{
            Coaches.add(new Coach(name,InputManger.inputPickyMenu(name)));
        });

        OutputView.printResult();
        OutputView.printGubn();
        OutputView.printCategory(Week.getInstance().toString());
        recommendMenu(Coaches);
        Coaches.stream().forEach(coach -> System.out.println(coach));
        OutputView.recommendFinish();
    }

    private static void recommendMenu(List<Coach> coaches){
        Week.getInstance().getCategories().forEach(category->{
            recommend(category,coaches);
        });
    }

    private static void recommend(Menu category, List<Coach> coaches){
        coaches.stream().forEach(coach -> {
            coach.setRecommendedMenu(category);
        });
    }
}
