package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    /** 현재 자동차의 이름을 반환 */
    public String getName() {
        return this.name;
    }
    
    /** 현재 자동차의 위치값을 반환 */
    public int getPosition() {
        return this.position;
    }
    
    /** 자동차를 1칸 앞으로 전진 */
    public void moveForward() {
        this.position++;
    }
    
    /** 현재 진행상황을 문자열로 반환 */
    public String getStatus() {
        return this.name + " : " + "-".repeat(position); // Since Java 11
    }
}
