import java.util.ArrayList;
import domain.*;
import InOut.*;

/**
 * CarRace
 */
public class CarRace {
    private ArrayList<Car> cars = new ArrayList<Car>();

    public void start(){
        //scan
        
        //create cars and control
        addCar();
        
        //execute
        runCar();

        //printresult
        
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