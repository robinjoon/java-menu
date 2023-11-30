package menu.output;

public class OutputManger {
    public static void startGuide() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachNameGuide() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputHateNameGuide(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coachName);
    }

    public static void recommendResultGuide() {
        System.out.println("메뉴 추천 결과입니다.");
    }

    public static void endGuide() {
        System.out.println("추천을 완료했습니다.");
    }
}
