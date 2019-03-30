package domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
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
        return ((this.position > max) ? this.position : max);
    }

    public boolean isVictoryCar(int max, int cnt){
        String victoryCarName = "";
        boolean result = (this.position == max) ? true : false;
        if(result){
            if(cnt >= 1){
                victoryCarName += ", ";
            }
            victoryCarName += this.name;
            System.out.print(victoryCarName);
        }
        return result;
    }
}
