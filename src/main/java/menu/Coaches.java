package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.view.InputManger;

public class Coaches {
    private final List<Coach> coaches = new ArrayList<>();

    Coaches(String input){
        Arrays.stream(input.split(",")).forEach(name ->{
            coaches.add(new Coach(name, InputManger.inputPickyMenu(name)));
        });
    }
}
