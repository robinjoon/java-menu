package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.coach.Coaches;
import menu.domain.recommend.Recommend;
import menu.domain.recommend.RecommendDTO;
import menu.input.InputManager;
import menu.output.OutputManger;
import menu.util.RetryHelper;

public class Application {
    public static void main(String[] args) {
        OutputManger.startGuide();
        Coaches coaches = makeCoaches();
        addHateMenus(coaches);
        Recommend recommend = makeRecommend(coaches);
        RecommendDTO recommendDTO = new RecommendDTO(recommend);
        printRecommendResult(recommendDTO);
    }

    private static void addHateMenus(Coaches coaches) {
        List<String> seperatedCoachNames = coaches.getCoachNames();
        for (String coachName : seperatedCoachNames) {
            addHateMenus(coaches, coachName);
        }
    }

    private static void addHateMenus(Coaches coaches, String coachName) {
        RetryHelper.retry(() -> {
            OutputManger.inputHateNameGuide(coachName);
            String hateMenus = InputManager.getString();
            coaches.addHateMenus(coachName, hateMenus);
            return Void.TYPE;
        });
    }

    private static Coaches makeCoaches() {
        OutputManger.inputCoachNameGuide();
        Coaches coaches = RetryHelper.retry(() -> {
            String coachNames = InputManager.getString();
            return new Coaches(coachNames);
        });
        return coaches;
    }

    private static void printRecommendResult(RecommendDTO recommendDTO) {
        OutputManger.recommendResultGuide();
        OutputManger.recommendResult(recommendDTO);
        OutputManger.endGuide();
    }

    private static Recommend makeRecommend(Coaches coaches) {
        Recommend recommend = new Recommend(coaches);
        for (int i = 0; i < 5; i++) {
            recommend.selectNextMenuType(Randoms.pickNumberInRange(1, 5));
            recommend.selectMenu();
        }
        return recommend;
    }
}
