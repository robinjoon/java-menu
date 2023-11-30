package menu.coach;

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

}