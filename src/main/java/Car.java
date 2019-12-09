/**
 * Precourse 2주차
 * Car.java
 * Purpose: Car 객체로 자동차의 이름과 위치 변수를 포함하고 있다. 또한 앞으로 전진하고 현재 위치를
 *          출력해주는 메소드를 포함하고 있다.
 *
 * @version         1.00 12/3/2019
 * @author          김태헌
 */
public class Car {
    private final String name;
    private int position = 0;

    /**
     * 파라미터 name 으로 이름을 초기화하고, instance 를 생성해 준다.
     * @param name
     */
    public Car(String name) {
        this.name = name;
    }

    /**
     * 0~10 사이의 랜덤 변수를 생성해 4 이상인 경우엔 position 을 1만큼 증가시키고 현재 위치를
     * 출력해준 뒤 1을 return 해준다. 4미만인 경우 position 에 변화 없이 현재 위치를 출력해주고
     * 0을 return 해준다
     *
     * @return 움직이는 거리
     */
    int printMovingForward() {
        int randomValue = (int) (Math.random() * 10);

        System.out.print(name + " : ");
        if (randomValue >= 4) {
            this.position++;
            for (int i = 0; i < this.position; i++) {
                System.out.print("-");
            }
            return 1;
        }
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        return 0;
    }

    /**
     * Car instance 의 이름을 반환해준다.
     * @return  name
     */
    public String toString() {
        return name;
    }
}
