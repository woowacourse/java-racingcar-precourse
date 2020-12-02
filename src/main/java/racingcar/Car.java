package racingcar;

public class Car implements Comparable<Car>{
    private static final String MOVE_REPRESENT="-";
    private static final Integer MOVE_LIMIT=4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(){
        position++;
    }

    boolean isSatisfiedByNumber(int number){
        return number>=MOVE_LIMIT;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.position,this.position);
    }

    public void printCurrentPosition(){
        System.out.print(String.format("%s : ",name));
        for(int i=0;i<position;i++){
            System.out.print(MOVE_REPRESENT);
        }
        System.out.println();
    }
}
