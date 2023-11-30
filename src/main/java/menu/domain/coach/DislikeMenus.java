package menu.domain.coach;

import static menu.constants.ErrorMessage.INVALID_DISLIKE_MENU_MAXIMUM_SIZE;
import static menu.constants.ErrorMessage.formatErrorWithRetry;

import java.util.List;
import menu.domain.Menu;

public class DislikeMenus {
    private final List<Menu> dislikeMenus;

    public DislikeMenus(List<Menu> dislikeMenus) {
        this.dislikeMenus = dislikeMenus;
        validate(dislikeMenus);
    }

    private void validate(List<Menu> dislikeMenus) {
        validateSize(dislikeMenus);
    }

    private void validateSize(List<Menu> dislikeMenus) {
        if (dislikeMenus.size() > 2) {
            throw new IllegalArgumentException(formatErrorWithRetry(INVALID_DISLIKE_MENU_MAXIMUM_SIZE));
        }
    }

    public void add(Menu menu) {
        dislikeMenus.add(menu);
    }
}
