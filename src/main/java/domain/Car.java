package domain;

public class Car {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        assertName(name);
        this.name = name;
    }

    private void assertName(String name) {
        if(name.length() > MAX_CAR_NAME_LENGTH || name.length() <= 0)
            throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
