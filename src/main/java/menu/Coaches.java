package menu;

import static menu.CommonErrorMessage.errorFlag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.view.InputManger;

public class Coaches {
    private final List<Coach> coaches = new ArrayList<>();

    public List<Coach> getCoaches() {
        return coaches;
    }

    Coaches(String input) {
        Arrays.stream(input.split(",")).forEach(name -> {
            String pickyMenu = "";
            while (true) {
                try {
                    pickyMenu = InputManger.inputPickyMenu(name);
                    validatePickyMenu(pickyMenu);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            coaches.add(new Coach(name,pickyMenu));
        });
    }

    private void validatePickyMenu(String pickyEating) {
        Arrays.stream(pickyEating.split(",")).forEach(menu -> {
            if (!menu.isEmpty() && !Menu.hasMenu(menu)) {
                throw new IllegalArgumentException(errorFlag + "메뉴가 존재하지 않습니다,");
            }
            ;
        });
    }
}
