package menu.domain;

class Menu {
    private final MenuType type;
    private final String name;

    Menu(MenuType type, String name) {
        this.type = type;
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
