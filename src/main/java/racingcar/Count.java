package racingcar;

/**
 * @author yhh1056
 * @since 2020/12/04
 */
public class Count {
    private int racingCount = 0;

    public int validate(String input) {
        try {
            racingCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 허용하는 숫자가 아닙니다.");
        }

        if (racingCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이어야 합니다.");
        }

        if (racingCount > 30) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 30회 이하여야 합니다.");
        }
        return racingCount;
    }
}
