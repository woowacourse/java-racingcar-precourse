package racingcar;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;
    ComputeRelatedCar computeRelatedCar = new ComputeRelatedCar();
    public Car(String name) {
        this.name = name;
    }
    public void decidePositionNumber(){
        if(computeRelatedCar.informCanFoward()) {
            this.position += 1;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }
    public int compareTo(Car tmpCarObjectParameter){
        return tmpCarObjectParameter.getPosition()-this.position;
    }
    // 추가 기능 구현
}
