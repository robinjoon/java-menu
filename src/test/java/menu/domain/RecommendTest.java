package menu.domain;

import static menu.domain.ExceptionMessage.DUPLICATE_MENU_TYPE;

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
                .hasMessageContaining(DUPLICATE_MENU_TYPE);
    }

    @DisplayName("못 먹는 음식이 추천되지 않는지 확인")
    @Test
    void hateMenuRecommend() {
        Coaches coaches = new Coaches("aa,bb,cc");
        coaches.addHateMenus("aa", "깐풍기");
        Recommend recommend = new Recommend(coaches);
        Coach aa = coaches.getCoaches().stream()
                .filter(coach -> coach.getName().equals("aa"))
                .findFirst().orElseThrow();
        Assertions.assertThat(recommend.isInvalidSelectedMenuName(aa, "깐풍기"))
                .isTrue();
    }
}