package domain;

public class Name {
    String name;

    public Name(String name) {
        checkValid(name);
        this.name = name;
    }

    private void checkValid(String name) {
        if (0 < name.length() && name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
