package menu.view;

public class OutputView {
    public static void recommendMenuStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public static void requestInputCoachName(){
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void requestInputPickyEating(String name){
        System.out.println();
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n",name);
    }

    public static void printResult(){
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
    }

    public static void printGubn(){
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }

    public static void printCategory(String category){
        System.out.println(category);
    }

    public static void printCoachMenu(String coachMenu){
        System.out.println(coachMenu);
    }

    public static void recommendFinish(){
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
