package menu.coach;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("싫어하는 메뉴에 공백과 다른 것이 동시에")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidHateMenuCount(String invalid) {
        Assertions.assertThatThrownBy(() -> new Coach("aaa", "쌈밥", invalid))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 못 먹는 메뉴 입력에 공백과 메뉴가 동시에 포함될 수 없습니다.");
    }
}