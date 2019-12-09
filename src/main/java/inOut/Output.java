package inOut;
import domain.Car;
/**
 * Output
 */

import java.util.ArrayList;

public class Output {
    ArrayList<Car> carlist;

    public Output(ArrayList<Car>cars){
        carlist=cars;
        go();
    }
    
    public void go(){
        printCarsResult();
    }


    public void printCarsResult(){
        for (Car each:carlist){
            System.out.println(each.getName()+":"+
            transPosition(each.getPosition()));
        }
        System.out.println();
    }

    public String transPosition(int position){
        String dash="";
        for (int i =0; i<position; i++){
            dash=dash+"-";
        }
        return dash;
    }
    

}