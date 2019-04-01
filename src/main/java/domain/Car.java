package domain;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    /**
     * 랜덤값에 따라 전진할지 멈출지 결정하는 함수
     * 전진하면 position은 1증가한다.
     */
    public void goOrStop(){
        int ran=(int)Math.random()*10;
        if(ran>=4){
            position++;
        }
    }

    public String printPosition(){
        StringBuilder positionStatus = new StringBuilder(name+" : ");
        for(int i=0; i<position; i++){
            positionStatus.append("-");
        }
        return positionStatus.toString();
    }

    /**
     * 내림차순 정렬
     */
    @Override
    public int compareTo(Car o) {
        return o.position-this.position;
    }
}
