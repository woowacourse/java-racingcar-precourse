/*
 * Car
 *
 * ver 1.0
 *
 * 2019.12.07
 *
 * CopyRight
 *
 */
package domain;

public class Car implements Comparable<Car> {
    /*
     * Car 클래스 입니다.
     * Car객체를 생성시키는 데이터 타입 클래스입니다.
     */
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } // 객체의 이름을 반환합니다

    public int getPosition() {
        return position;
    } // 객체의 현재 위치(position)을 반환합니다.

    public int makeRandom() { // 랜덤생성 메소드
        double random_Float = Math.random() * 9;
        int random_Int = (int)random_Float;
        return random_Int;
    }

    public void moveToCar() { // 차를 움직이는 메소드 입니다
        int random = makeRandom();
        if (random >= 4) {
            position ++;
        } else {
            // 차가 정지한것입니다.
        }
    }

    public void progressOfCar() { // 현재차의 위치를 출력시키는 메소드 입니다.(이름과 위치 출력)
        String base_format = this.name + ':';
        System.out.print(base_format);
        for (int progress = 0; progress < position; progress++) {
            System.out.print('-');
        }
        System.out.print("\n");
    }

    @Override
    public int compareTo(Car car2) { // 객체를 sorting 하기 위해서 오버라이드하였습니다.
        int position2 = car2.getPosition();
        if (position == position2) {
            return 0;
        } else if (position2 > position) {
            return 1;
        } else {
            return -1;
        }
    }

}
