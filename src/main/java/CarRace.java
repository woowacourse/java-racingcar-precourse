import java.util.ArrayList;
import domain.*;
import inOut.*;

/**
 * CarRace
 */
public class CarRace {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int trys =5;
    public void start(){
        //scan
        
        //create cars and control
        addCar();
        
        System.out.println("실행결과");
        //execute
        for(int i = 0; i<trys; i++){
            runCar();
            //print result
            Output out = new Output(cars);
        }
        //print total result
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