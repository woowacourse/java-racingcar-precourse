package domain.model;

/**
 * @author 김시영
 * @apiNote 탈 것이 다양해지는 것을 고려해 상위 클래스인 Vehicle을 각각의 탈 것들이 상속받도록 설계
 * @since 2019-12-05
 */
public class Vehicle {
    private static final String HYPHEN_FOR_POSITION = "-";
    private static final String SPACING_WORDS = " : ";

    private final String name;
    private int position = 0;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForwardPosition(boolean goOrStop, Vehicle kind) {
        if (goOrStop && kind instanceof Car) {
            position++;
        }
        //TODO 자동차가 아닌, 다른 수단 : Bicycle, Airplane 등일 경우 포지션 이동의 범위가 달라진다면 추가 작업(클래스 생성 및 포지션 증감 결정)
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(SPACING_WORDS);
        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN_FOR_POSITION);
        }
        return sb.toString();
    }
}
