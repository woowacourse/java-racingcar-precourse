package domain.car;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(name + "은 5글자 보다 긴 이름입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
