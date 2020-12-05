package racingcar;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public String goOrStop(int randomNumber) {
        if (go(randomNumber)) {
            moveForward();
            System.out.println(randomNumber);
            moveForward();
            return "go";
        }
        System.out.println(randomNumber);
        return "stop";
    }

    private void moveForward() {
        this.position++;
        System.out.println(position);
    }

    public static boolean go(int randomNumber) {
        return randomNumber >= 4;
    }

}
