package domain;

class Name {
    private String name;
    private static final Integer LOWER_BOUND = 1;
    private static final Integer UPPER_BOUND = 5;

    Name(String name) {
        checkValid(name);
        this.name = name;
    }

    private void checkValid(String name) {
        if (LOWER_BOUND < name.length() && name.length() > UPPER_BOUND) {
            throw new IllegalArgumentException("1 ~ 5 자 사이의 이름을 입력해주세요.");
        }
    }

    String getName() {
        return name;
    }
}
