/*
 * Class:   CarMain
 *
 * Version: 1.0
 *
 * Date:    2019-12-10
 *
 * Author:  Jae Bin Lee
 *
 */
package domain;

public class CarMain {
    public static void main(String[] args){
        Car[] cars;
        int gameCount=0;

        cars=Car.initCars();
        gameCount=Car.getGameCount();
        for(int i=0;i<gameCount;i++){
            for(int j=0;j<cars.length;j++){
                cars[j].moveCar();
                cars[j].printResult();
            }
            System.out.println();
        }

        Car.printFinalResult(cars);
    }
}
