package menu;

import static menu.Menu.ASIAN;
import static menu.Menu.CHINESE;
import static menu.Menu.FRENCH;
import static menu.Menu.JAPANESE;
import static menu.Menu.KOREAN;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MenuTest {

    @ParameterizedTest
    @DisplayName("카테고리 리턴테스트")
    @MethodSource("categoryParameter")
    void getCategory(int number, Menu menu) {
        assertThat(
                Menu.getCategory(number)
        ).isEqualTo(menu);
    }

    static Stream<Arguments> categoryParameter() {
        return Stream.of(
                Arguments.of("1", JAPANESE),
                Arguments.of("2", KOREAN),
                Arguments.of("3", CHINESE),
                Arguments.of("4", ASIAN),
                Arguments.of("5", FRENCH)
        );
    }



}