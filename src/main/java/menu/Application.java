package menu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.coach.Coaches;
import menu.input.InputManager;
import menu.output.OutputManger;
import menu.recommend.Recommend;
import menu.recommend.RecommendDTO;
import menu.util.RetryHelper;

public class Application {
    public static void main(String[] args) {
        OutputManger.startGuide();
        OutputManger.inputCoachNameGuide();
        Coaches coaches = RetryHelper.retry(() -> {
            String coachNames = InputManager.getString();
            return new Coaches(coachNames);
        });
        List<String> seperatedCoachNames = coaches.getCoachNames();
        for (String coachName : seperatedCoachNames) {
            RetryHelper.retry(() -> {
                OutputManger.inputHateNameGuide(coachName);
                String hateMenus = InputManager.getString();
                coaches.addHateMenus(coachName, hateMenus);
                return Void.TYPE;
            });
        }
        Recommend recommend = new Recommend(coaches);
        for (int i = 0; i < 5; i++) {
            recommend.selectNextMenuType(Randoms.pickNumberInRange(1, 5));
            recommend.selectMenu();
        }
        RecommendDTO recommendDTO = new RecommendDTO(recommend);
        OutputManger.recommendResultGuide();
        OutputManger.recommendResult(recommendDTO);
        OutputManger.endGuide();
    }
}
