package menu;

import camp.nextstep.edu.missionutils.Console;

import static menu.OutputView.*;
import static menu.Message.*;

import java.util.List;

import static menu.InputValidator.*;

public class InputView {

    public static String[] inputCoachNames() {
        printMessage(INPUT_COACH_PROMPT);
        String rawInput = Console.readLine();
        String[] coachNames = rawInput.split(",");
        try {
            coachNameSizeValidator(coachNames);
        } catch (IllegalArgumentException e) {
            printMessage(String.valueOf(e));
        }
        return coachNames;
    }

    public static String[] inputCannotEatMenus(String name) {
        printMessage(String.format(INPUT_CANT_EATABLE_MENU, name));
        String rawInput = Console.readLine();
        return rawInput.split(",");
    }
}
