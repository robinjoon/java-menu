package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesTest {
    @DisplayName("코치 이름 중복")
    @ParameterizedTest
    @ValueSource(strings = {"a,a", "a,b,a"})
    void invalidCoachNameLength(String coachNames) {
        Assertions.assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치이름은 중복될 수 없습니다.");
    }

    @DisplayName("코치 인원 2 미만 혹은 5 초과")
    @ParameterizedTest
    @ValueSource(strings = {"a", "a,b,c,d,e,f"})
    void invalidCoachNameCount(String coachNames) {
        Assertions.assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치는 최소 2명, 최대 5명 입력할 수 있습니다.");
    }
}