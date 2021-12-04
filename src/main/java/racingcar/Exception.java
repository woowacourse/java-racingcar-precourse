package racingcar;

public class Exception {
    public static void isEmptyName(String[] allCarName) {
        for (String name : allCarName) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
