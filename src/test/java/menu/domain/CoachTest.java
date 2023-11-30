package menu.domain;

import static menu.domain.ExceptionMessage.COACH_NAME_BLANK;
import static menu.domain.ExceptionMessage.HATE_MENU_INPUT_BLANK_AND_NAME;
import static menu.domain.ExceptionMessage.HATE_MENU_NOT_CONTAIN_MENU_BOARD;
import static menu.domain.ExceptionMessage.INVALID_COACH_NAME_LENGTH;
import static menu.domain.ExceptionMessage.INVALID_HATE_MENU_COUNT;

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
                .hasMessageContaining(HATE_MENU_NOT_CONTAIN_MENU_BOARD);
    }

    @Test
    @DisplayName("싫어하는 메뉴가 3개 이상")
    void invalidHateMenuCount() {
        Assertions.assertThatThrownBy(() -> new Coach("aaa", "쌈밥", "동파육", "된장찌개"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_HATE_MENU_COUNT);
    }

    @DisplayName("싫어하는 메뉴에 공백과 다른 것이 동시에")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void invalidHateMenuCount(String invalid) {
        Assertions.assertThatThrownBy(() -> new Coach("aaa", "쌈밥", invalid))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(HATE_MENU_INPUT_BLANK_AND_NAME);
    }

    @DisplayName("코치 이름 길이 2 미만 혹은 4 초과")
    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaaa"})
    void invalidCoachNameLength(String name) {
        Assertions.assertThatThrownBy(() -> new Coach(name, "쌈밥"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_COACH_NAME_LENGTH);
    }

    @DisplayName("코치 이름 공백 포함")
    @Test
    void coachNameWithBlank() {
        Assertions.assertThatThrownBy(() -> new Coach("a ", "쌈밥"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COACH_NAME_BLANK);
    }
}