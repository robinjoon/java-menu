package menu;

import java.util.List;


import static menu.Message.*;
public class OutputView {

    public static void printMessage(String msg){ System.out.println(msg);}

    public static void printResults(List<List<String>> results,List<String> categories){
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

    private static void printMenu(List<List<String>> results){
        for(List<String> result : results){
            printMessage(String.format(MENU_RECOMMEND_RESULT_FORMAT,
                    result.get(0),
                    result.get(1),
                    result.get(2),
                    result.get(3),
                    result.get(4),
                    result.get(5)
            ));
            System.lineSeparator();
        }
    }
}
