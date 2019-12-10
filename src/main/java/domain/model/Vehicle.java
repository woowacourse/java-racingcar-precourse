package domain.model;

/**
 * @author 김시영
 * @apiNote 탈 것이 다양해지는 것을 고려해 상위 클래스인 Vehicle을 각각의 탈 것들이 상속받도록 설계
 * @since 2019-12-05
 */
public abstract class Vehicle {

    private final String name;

    protected Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPosition();

    public abstract void goForwardPosition(boolean goOrStop);
        //TODO 자동차가 아닌, 다른 수단 : Bicycle, Airplane 등일 경우 포지션 이동의 범위가 달라진다면 추가 작업(클래스 생성 및 포지션 증감 결정)

    public abstract String toString();


}
