package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    /** 자동차를 1칸 앞으로 전진 */
    public void moveForward() {
        this.position++;
    }
    
    /** 현재 진행상황을 문자열로 반환 */
    public String getStatus() {
        return this.name + " : " + "-".repeat(position);
    }
}
