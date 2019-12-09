import java.util.ArrayList;
import domain.*;
import inOut.*;

/**
 * CarRace
 */
public class CarRace {
    private ArrayList<Car> cars = new ArrayList<Car>();

    public void start(){
        //scan
        
        //create cars and control
        addCar();
        
        System.out.println("실행결과");
        //execute
        for(int i = 0; i<3; i++)
            runCar();
            //printresult
            System.out.println(cars.get(0).getPosition());
        
    }

    public void addCar(){
        cars.add(new Car("test"));
    }
    public void runCar(){
        for (Car each : cars){
            each.run();
        }
    }
}