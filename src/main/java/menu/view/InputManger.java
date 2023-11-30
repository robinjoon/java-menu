package menu.view;

import menu.Validate;

public class InputManger {
    public static String inputCoachName() {
        while (true) {
            try {
                String input = InputView.inputCoachName();
                Validate.validateCoachName(input);
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputPickyMenu(String coachName) {
        while (true) {
            try {
                String input = InputView.inputPickyEating(coachName);
                Validate.validatePickyEating(input);
                return input;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
