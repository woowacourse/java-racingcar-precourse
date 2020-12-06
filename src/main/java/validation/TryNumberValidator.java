package validation;

public class TryNumberValidator {
    private TryNumberValidator() {
    }

    public static void validateTryNumber(int tryNumber) throws IllegalArgumentException {
        if (tryNumber < 1) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }
    }
}
