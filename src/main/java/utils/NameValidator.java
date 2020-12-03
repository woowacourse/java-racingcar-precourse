package utils;

public class NameValidator {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public static void validate(String name){
        if(!isValid(name)){
            throw new IllegalStateException("5자 이하의 이름을 입력해주세요.");
        }
    }

    private static boolean isValid(String name) {
        return name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH;
    }
}
