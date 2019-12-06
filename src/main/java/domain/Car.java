package domain;

/**
 * @author 김시영
 * @apiNote 사용자별로, 자동차를 생성하고 경주하기 위한 클래스입니다.
 * @since 2019-12-05
 */
public class Car {
    private static final String HYPHEN_FOR_POSITION = "-";
    private static final String SPACING_WORDS = " : ";

    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForwardPosition(boolean goOrStop) {
        if (goOrStop) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(SPACING_WORDS);
        for(int i=0; i<position; i++){
            sb.append(HYPHEN_FOR_POSITION);
        }
        return sb.toString();
    }
}
