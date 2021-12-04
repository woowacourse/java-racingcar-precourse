package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    static int NUMBER_OF_CAR = 0;
    static int START_POSITION = -1;
    static int MOVE_CONDITION = 4;

    public static void main(String[] args) {
        String[] nameOfCars;
        int numOfTry;
        ArrayList<Car> cars = new ArrayList<>();
        Validation validation = new Validation();
        Print print = new Print();
        Input input = new Input();

        nameOfCars = input.inputNameOfCars(validation);
        numOfTry = input.inputNumberOfTry(validation);
        createCars(nameOfCars, cars);
        racingResult(numOfTry, cars, print);
        print.printRacingWinner(findRacingWinner(cars));
    }

    public static void moveOrStop(ArrayList<Car> cars){
        for(Car c: cars){
            if(Randoms.pickNumberInRange(0, 9) >= MOVE_CONDITION){
                c.moveForward();
            }
        }
    }

    public static ArrayList<String> findRacingWinner(ArrayList<Car> cars){
        int winnerPosition = START_POSITION;
        ArrayList<String> nameOfWinner = new ArrayList<>();
        for(Car c: cars){
            if(c.getPosition() > winnerPosition){
                winnerPosition = c.getPosition();
            }
        }
        for(Car c: cars){
            if(c.getPosition() == winnerPosition){
                nameOfWinner.add(c.getName());
            }
        }
        return nameOfWinner;
    }

    public static void createCars(String[] nameOfCars, ArrayList<Car> car){
        // 입력받은 자동차의 수 만큼 car 객체 생성하고 car.name (생성자) 초기화
        for(String name: nameOfCars){
            car.add(NUMBER_OF_CAR, new Car(name));
            NUMBER_OF_CAR++;
        }
    }

    public static void racingResult(int numOfTry, ArrayList<Car> cars, Print print){
        System.out.println("실행결과");
        for(int i = 0; i < numOfTry; i++){
            moveOrStop(cars);
            print.printRacingResult(cars);
            System.out.println();
        }
    }
}
