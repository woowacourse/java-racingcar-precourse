package domain;
import java.util.Random;
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    // 추가 기능 구현
    public void running(){
        Random random=new Random();
        int rand=random.nextInt(10);
        if(rand>=4){
            position++;
        }
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
