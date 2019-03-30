package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            System.out.println(name + "은 잘못된 입력 값 입니다. (5글자 초과)");
            System.exit(0);
        }
        this.name = name;
    }

    public void printCarPosition(boolean result) {
        if (result) {
            this.position++;
        }
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int collectMaxPosition(int max) {
        int resultMaxPosition = (this.position > max) ? this.position : max;

        return resultMaxPosition;
    }

    public boolean isVictoryCar(int max, int cnt) {
        String victoryCarName = "";
        boolean result = (this.position == max) ? true : false;
        if (result) {
            if (cnt >= 1) {
                victoryCarName += ", ";
            }
            victoryCarName += this.name;
            System.out.print(victoryCarName);
        }
        return result;
    }
}
