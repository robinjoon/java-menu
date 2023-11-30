package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Recommendation;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachNames;
import menu.domain.coach.DislikeMenus;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private List<Coach> coaches;
    private Recommendation recommendation;
    private Map<String, DislikeMenus> dislikeMenus;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        coaches = new ArrayList<>();
        recommendation = new Recommendation();
    }
    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        CoachNames coachNames = inputView.readNames();
        for(String name : coachNames.getNames()) {
            DislikeMenus dislike = inputView.readDislikeMenus(name);
            Coach coach = new Coach(name, dislike);
            coaches.add(coach);
            dislikeMenus.put(name, dislike);
        }
        recommendation.start();
//        outputView.printMenuRecommendation();
        System.out.println("추천을 완료했습니다");
    }
}
