package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        Coach coach = inputView.readNames();
//        for(String name : names) {
//            List<String> dislikeMenus = inputView.readDislikeMenus(name);
//        }
//        outputView.printMenuRecommendation();
        System.out.println("추천을 완료했습니다");
    }
}
