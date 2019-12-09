public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    int printMovingForward() {
        int randomValue = (int) (Math.random() * 10);
        if (randomValue >= 4) {
            this.position++;
            System.out.print(name +" : ");
            for(int i=0;i<this.position;i++){
                System.out.print("-");
            }
            System.out.println();
            return 1;
        }
        System.out.print(name +" : ");
        for(int i=0;i<this.position;i++){
            System.out.print("-");
        }
        System.out.println();
        return 0;
    }
    public String toString(){
        return name;
    }
}
