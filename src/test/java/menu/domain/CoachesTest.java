package menu.domain;

import static menu.domain.ExceptionMessage.CONTINUITY_SEPARATOR;
import static menu.domain.ExceptionMessage.DUPLICATE_COACH_NAME;
import static menu.domain.ExceptionMessage.INVALID_COACH_COUNT;

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
                .hasMessageContaining(DUPLICATE_COACH_NAME);
    }

    @DisplayName("코치 인원 2 미만 혹은 5 초과")
    @ParameterizedTest
    @ValueSource(strings = {"a", "a,b,c,d,e,f"})
    void invalidCoachNameCount(String coachNames) {
        Assertions.assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_COACH_COUNT);
    }

    @DisplayName("연속된 구분자")
    @ParameterizedTest
    @ValueSource(strings = {"aa,,bb"})
    void continuitySeparator(String coachNames) {
        Assertions.assertThatThrownBy(() -> new Coaches(coachNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTINUITY_SEPARATOR);
    }
}