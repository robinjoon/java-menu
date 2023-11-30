package menu.coach;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {
    @Test
    @DisplayName("없는 메뉴를 싫어하는 메뉴로")
    void invalidHateMenu() {
        Assertions.assertThatThrownBy(() -> new Coach("aaa", "a", "동파육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 없는 메뉴를 못 먹는 음식으로 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("싫어하는 메뉴가 3개 이상")
    void invalidHateMenuCount() {
        Assertions.assertThatThrownBy(() -> new Coach("aaa", "쌈밥", "동파육", "된장찌개"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치가 못 먹는 음식은 0개 이상 2개 이하여야 합니다.");
    }

}