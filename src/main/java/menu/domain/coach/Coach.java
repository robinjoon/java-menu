package menu.domain.coach;

import java.util.List;
import menu.domain.Menu;

public class Coach {
    private final String name;
    private final DislikeMenus dislikeMenus;

    public Coach(String name, DislikeMenus dislikeMenus) {
        this.name = name;
        this.dislikeMenus = dislikeMenus;
    }

    public String getName() {
        return name;
    }

    public boolean isDislike(Menu menu) {
        return dislikeMenus.contains(menu);
    }
}
