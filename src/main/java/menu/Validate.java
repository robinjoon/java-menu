package menu;

import static menu.CommonErrorMessage.errorFlag;

import java.util.Arrays;

public class Validate {
    public static void validateCoachName(String input) {
        validateNameLength(input);
        validateCoachCount(input);
    }

    private static void validateNameLength(String input) {
        Arrays.stream(input.split(",")).forEach(name -> {
            if (name.length() > 4 || name.length() < 2) {
                throw new IllegalArgumentException(errorFlag + "코치 이름은 최소 2글자, 최대 4글자이다.");
            }
        });
    }

    private static void validateCoachCount(String input) {
        int countCoach = input.split(",").length;
        if (countCoach > 5 || countCoach < 2) {
            throw new IllegalArgumentException(errorFlag + "코치는 최소 2명, 최대 5명까지 식사를 함께 한다.");
        }
    }

    public static void validatePickyEating(String input) {
        validatePickyCount(input);
    }

    private static void validatePickyCount(String input){
        int pickyCount = input.split(",").length;
        if(pickyCount > 2){
            throw new IllegalArgumentException(errorFlag + "각 코치는 최소 0개, 최대 2개의 못 먹는 메뉴가 있다");
        }
    }
}

