package domain;

public class Car {
    private final String name;
    private int position = 0;
//    public int rand;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void goForward() {
        this.position++;
    }

    public void stop() {
        // Do Nothing
    }

    public String getPosition() {
        char[] pos = new char[this.position];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = '-';
        }
        return String.copyValueOf(pos);
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public void moveByRandomNumber() {
        int rand = getRandomNumber();
//        this.rand = rand;

        if (rand >= 4) {
            // 4 이상일 때 전진
            goForward();
        }

        if (rand <= 3) {
            // 3 이하일 때 멈춤
            stop();
        }
    }
}
