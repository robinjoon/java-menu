package menu;

import static menu.ErrorMessage.*;
public class InputValidator {

    public static void coachNameSizeValidator(String[] names){
        for(String name : names) {
            if ( name.length() < 2 || 4 < name.length() ) {
                throw new IllegalArgumentException(COACH_NAME_LEN_ERROR);
            }
        }
    }

}
