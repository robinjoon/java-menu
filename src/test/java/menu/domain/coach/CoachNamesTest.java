package menu.domain.coach;

import static menu.constants.ErrorMessage.CONTAINS_WHITESPACE;
import static menu.constants.ErrorMessage.DUPLICATED_COACH_NAME;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_LENGTH;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_MAXIMUM_SIZE;
import static menu.constants.ErrorMessage.INVALID_COACH_NAME_MINIMUM_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoachNamesTest {
    @Test
    void validCoachNamesTest() {
        List<String> names = List.of("포비","제임스");
        CoachNames coachNames = new CoachNames(names);
        assertEquals(names, coachNames.getNames());
    }

    @Test
    void invalidCoachNamesBlankNameTest() {
        List<String> names = List.of("포비"," ");
        assertThatThrownBy(() -> new CoachNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINS_WHITESPACE);
    }

    @Test
    void invalidCoachNamesLengthTest() {
        List<String> names = List.of("포비","제임스","우아한테크코스");
        assertThatThrownBy(() -> new CoachNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_COACH_NAME_LENGTH);
    }

    @Test
    void invalidCoachNamesDuplicatedTest() {
        List<String> names = List.of("포비","제임스","포비");
        assertThatThrownBy(() -> new CoachNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_COACH_NAME);
    }

    @Test
    void invalidCoachNamesMinimumSizeTest() {
        List<String> names = List.of("포비");
        assertThatThrownBy(() -> new CoachNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_COACH_NAME_MINIMUM_SIZE);
    }

    @Test
    void invalidCoachNamesMaximumSizeTest() {
        List<String> names = List.of("포비","제임스","토미","강나윤","나윤","우아한","테크코스");
        assertThatThrownBy(() -> new CoachNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_COACH_NAME_MAXIMUM_SIZE);
    }
}