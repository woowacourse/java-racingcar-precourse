package racingcar;

public class ErrorCheck {

    public static void nameCheck(String carName) {
        if (carName.isEmpty()) {
            System.out.println("[ERROR] 이름은 빈칸일 수 없습니다.");
            throw new IllegalArgumentException();
        }

        if (carName.length() >5) {
            System.out.println("[ERROR] 이름은 5자 이하여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void numberCheck(int number) {
        if (number < 1) {
            System.out.println("[ERROR] 시도 횟수는 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
