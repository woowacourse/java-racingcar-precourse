package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    /**
     * 자동차의 전진 기능을 담당하는 메소드입니다.
     */
    public void moveForward() {
        position++;
    }

    /**
     * 자동차의 이름과 이동한 거리를 출력하는 메소드입니다.
     * (e.g., "pobi : ---")
     */
    public String printStatus() {
        String status = name;
        status += " : ";
        for (int i=0; i<position; i++) {
            status += "-";
        }
        return status;
    }

}
