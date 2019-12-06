package domain;

/**
 * Car class - 경주에 사용할 자동차 Class
 *
 * @author 김범준(ddaaac)
 * @version 1.02 2019-12-06
 */
public class Car {
    /**
     * 자동차의 이름
     */
    private final String name;

    /**
     * 자동차의 위치
     */
    private int position = 0;

    /**
     * Car의 생성자
     *
     * @param name 입력받은 이름으로 name 변수 초기화
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 자동차의 위치를 일정 확률로 1 증가시키는 메소드
     *
     * @return Boolean 전진했으면 true, 하지 않았으면 false
     */
    protected void moveForward() {
        int randomNumber = (int) (Math.random() * Admin.MAX_RANDOM_NUMBER);

        if (randomNumber >= Admin.MIN_THRESHOLD) {
            position++;
        }
    }

    /**
     * 자동차의 이름과 현재 포지션만큼 '-'를 출력하는 메소드
     */
    protected void printPosition() {
        System.out.print(name + ": ");
        for (int i = 0; i <= position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    /**
     * name 변수의 getter
     */
    protected String getName() {
        return this.name;
    }

    /**
     * position 변수의 getter
     */
    protected int getPosition() {
        return this.position;
    }
}
