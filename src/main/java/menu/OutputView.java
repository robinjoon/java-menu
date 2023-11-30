package menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.Message.*;
public class OutputView {

    public static void printMessage(String msg){ System.out.println(msg);}

    public static void printResults(HashMap<String,List<String>> results,List<String> categories){
        printMessage(OUTPUT_RESULT_PROMPT);
        printMessage(WEEKDAYS_PROMPT);
        printCategory(categories);
        printMenu(results);
        printMessage(COMPLETE_RECOMMEND_MESSAGE);
    }

    private static void printCategory(List<String> categories){
        printMessage(String.format(CATEGORY_RECOMMEND_RESULT_FORMAT,
                categories.get(0),
                categories.get(1),
                categories.get(2),
                categories.get(3),
                categories.get(4)
        ));
    }

    private static void printMenu(HashMap<String, List<String>> results){
        for(Map.Entry entry : results.entrySet()){
            List<String> menus = (List<String>) entry.getValue();
            printMessage(String.format(MENU_RECOMMEND_RESULT_FORMAT,
                    entry.getKey(),
                    menus.get(0),
                    menus.get(1),
                    menus.get(2),
                    menus.get(3),
                    menus.get(4)
            ));
        }
    }
}
