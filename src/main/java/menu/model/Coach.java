package menu.model;

public class Coach {

    private final String name;

    public Coach(String name) {
        this.name = name;
    }

    public static Coach from(String input) {
        return new Coach(input);
    }

    @Override
    public String toString() {
        return name;
    }
}
