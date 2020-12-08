package domain.racingcar;

/**
 * 이름으로 자동차를 생성하는 클래스
 *
 * @author 조연우
 * @version 1.0 2020년 12월 7일
 */
public class CarFactory {

    public static Car createCar(final String carName) {
        return new Car(carName);
    }
}