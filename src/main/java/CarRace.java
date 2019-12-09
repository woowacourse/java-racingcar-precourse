import java.util.ArrayList;
import domain.*;
import inOut.*;

/**
 * CarRace
 */
public class CarRace {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int trys =5;
    TotalOutput totalOutput;
    Output out;

    public void start(){
        //scan
        
        //create cars and control
        addCar("test");
        addCar("test2");
        
        System.out.println("실행결과");
        //execute
        for(int i = 0; i<trys; i++){
            runCar();
            //print result
            out = new Output(cars);
        }
        //print total result
        totalOutput = new TotalOutput(cars);
    }

    public void addCar(String name){
        cars.add(new Car(name));
    }
    public void runCar(){
        for (Car each : cars){
            each.run();
        }
    }
}