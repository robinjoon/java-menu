package menu.output;

import java.util.List;
import java.util.Map;
import menu.domain.RecommendDTO;

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

    public static void recommendResult(RecommendDTO recommendDTO) {
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        String collect = String.join(" | ", recommendDTO.getMenuTypes());
        collect = String.format("[ 카테고리 | %s ]", collect);
        System.out.println(collect);
        Map<String, List<String>> recommendMenus = recommendDTO.getRecommendMenus();
        for (String coachName : recommendMenus.keySet()) {
            String join = String.join(" | ", recommendMenus.get(coachName));
            System.out.printf("[ %s | %s ]\n", coachName, join);
        }
    }
}
