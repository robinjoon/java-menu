package menu;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import static menu.Message.*;
import static menu.OutputView.*;
import static menu.InputView.*;
import static menu.ErrorMessage.*;

public class MenuController {

    public static void run() {
        printMessage(START_PROGRAM_PROMPT);
        List<Coach> coaches = generateCoaches();

        List<List<String>> menuResults = new ArrayList<>();
        MenuGenerator menuGenerator = new MenuGenerator();
        List<String> categoryResult = menuGenerator.getRandomCategory();
        for (Coach coach : coaches) {
            List<String> menuResultOfEachCoach = menuGenerator.generateMenusForEachCoach(coach);
            List<String> menuResult = new ArrayList<>();
            menuResult.add(coach.name());
            menuResult.add(menuResultOfEachCoach.get(0));
            menuResult.add(menuResultOfEachCoach.get(1));
            menuResult.add(menuResultOfEachCoach.get(2));
            menuResult.add(menuResultOfEachCoach.get(3));
            menuResult.add(menuResultOfEachCoach.get(4));
            menuResults.add(menuResult);
        }
        OutputView.printResults(menuResults, categoryResult);
    }

    public static List<Coach> generateCoaches() {
        String[] coachNames = inputCoachNames();
        validateCoachesNumber(coachNames);
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            List<String> notEatableMenus = generateNotEatableMenusForEachCoach(name);
            coaches.add(new Coach(name, notEatableMenus));
        }
        return coaches;
    }


    private static void validateCoachesNumber(String[] coachNames) {
        if (coachNames.length < 2 || 5 < coachNames.length) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR);
        }
    }

    private static List<String> generateNotEatableMenusForEachCoach(String coach) {
        String[] menusNotEat = inputCannotEatMenus(coach);
        validateMenuNumber(menusNotEat);
        return Arrays.asList(menusNotEat);
    }

    private static void validateMenuNumber(String[] menuNames) {
        if (2 < menuNames.length) {
            throw new IllegalArgumentException(COACH_NUMBER_ERROR);
        }
    }

}
