package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void carMove(int randomNum) {
        if (randomNum >= 4) this.position++;
    }

    public void printCurStatus() {
        System.out.print(this.name + " : ");
        printCurMovement();
        System.out.println();
    }

    private void printCurMovement() {
        for (int i = 0; i < this.position; ++i) {
            System.out.print('-');
        }
    }
}
