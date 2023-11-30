package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RecommendTest {
    @DisplayName("3번 이상 동일한 카테고리 불가능")
    @Test
    void toMuchSameMenuType() {
        Coaches coaches = new Coaches("aa,bb,cc");
        Recommend recommend = new Recommend(coaches);

        recommend.selectNextMenuType(1);
        recommend.selectMenu();

        recommend.selectNextMenuType(1);
        recommend.selectMenu();

        Assertions.assertThatThrownBy(() -> recommend.selectNextMenuType(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("다른 카테고리 설정 필요");
    }
}