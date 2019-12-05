package domain;

/**
 * Car class - 경주에 사용할 자동차 Class
 *
 * @author 김범준(ddaaac)
 * @version 1.01 2019-12-05
 */
public class Car {
    /**
     * 자동차의 이름
     */
    private final String name;

    /**
     * Car의 생성자
     *
     * @param name 입력받은 이름으로 name 변수 초기화
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 자동차의 전진여부를 반환하는 메소드
     *
     * @param maxNumOfMoving 앞으로 전진할 수 있는 최대횟수
     * @return Boolean Array 전진했으면 true, 하지 않았으면 false로 이뤄진 maxNumOfMoving 크기의 정수 배열
     */
    protected Boolean[] moveCar(int maxNumOfMoving) {
        Boolean[] actualMoving = new Boolean[maxNumOfMoving];
        for (int i = 0; i < maxNumOfMoving; i++) {
            actualMoving[i] = ifCarCanMove();
        }
        return actualMoving;
    }

    /**
     * 자동차의 이름을 반환하는 메소드
     *
     * @return string 자동차 이름
     */
    protected String getName() {
        return this.name;
    }

    /**
     * 자동차가 한 번 전진했는지 반환하는 메소드
     *
     * @return Boolean 전진했으면 true, 하지 않았으면 false
     */
    private Boolean ifCarCanMove() {
        int randomNumber;
        randomNumber = (int) (Math.random() * Admin.maxRandomNumber);
        if (randomNumber >= Admin.minMovingNumber) {
            return true;
        }
        return false;
    }
}
