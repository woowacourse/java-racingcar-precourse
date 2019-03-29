package project;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    
    public void moveCar(){
        int num=getRandom();
        
    }
    public int getRandom() {
        randomNum = (int) (Math.random() * 10);
    }
    
    public boolean isCarMove(int num){
        return num>4?true:false;
    }

    // 추가 기능 구현
}
