package domain.model;

/**
 * @author 김시영
 * @apiNote 사용자별로, 자동차를 생성하고 경주하기 위한 클래스입니다.
 * @apiNote 탈 것이 다양해짐을 고려해 상위 클래스 Vehicle에 필요 기능하고 정의되어 있고, 이 클래스는 상속받아 사용.
 * @since 2019-12-05
 */
public class Car extends Vehicle {
    private static final String SPACING_WORDS = " : ";
    private static final String HYPHEN_FOR_POSITION = "-";
    private int position = 0;

    public Car(String name) {
        super(name);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void goForwardPosition(boolean goOrStop) {
        if (goOrStop) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(SPACING_WORDS);
        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN_FOR_POSITION);
        }
        return sb.toString();
    }
}