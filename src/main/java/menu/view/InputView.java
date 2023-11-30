package menu.view;

import camp.nextstep.edu.missionutils.Console;

class InputView {
    static String inputCoachName(){
        OutputView.requestInputCoachName();
        return Console.readLine();
    }

    static String inputPickyEating(String name){
        OutputView.requestInputPickyEating(name);
        return Console.readLine();
    }
}
