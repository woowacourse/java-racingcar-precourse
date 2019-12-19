package domain;

public class Count {
    private static final int EMPTY = 0;
    private final int goal;
    private int count;

    public Count(int goal) {
        checkCountValid();
        this.goal = goal;
        this.count = 0;
    }

    public void plusCount() {
        count++;
    }

    public boolean isNotLimitCount() {
        return goal == count;
    }

    private void checkCountValid() {
        if (goal == EMPTY) {
            throw new IllegalArgumentException("0이 아닌 카운트 값을 입력해주세요!");
        }
    }
}
