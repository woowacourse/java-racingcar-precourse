package racingcar;

import java.util.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    static List<Car> carList = new ArrayList<Car>();

    public static void main(String[] args) {
        CreateCars();

    }

    static void CreateCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames=GetCarNames();
        AddCarsToCarList(carNames);
    }

    static void AddCarsToCarList(String[] carNames){
        for(String s:carNames){
            Car c = new Car(s);
            carList.add(c);
        }
    }

    static String[] GetCarNames() {
        String carNamesInput = readLine();
        String carNames[];

        while(true){
            try{
                carNames=ParseCarNamesInput(carNamesInput);
                return carNames;
            } catch(IllegalArgumentException e){
                PrintErrorMessage(NameInputError);
            }
        }
    }

    final static String parser="/";

    static String[] ParseCarNamesInput(String carNamesInput){
        String[] carNames = carNamesInput.split(parser);
        for(String s:carNames){
            if(s.length()>5){
                PrintErrorMessage(NameInputError);
                throw new IllegalArgumentException();
            }
        }

        return carNames;
    }

    static int NameInputError=1;
    static int TimeInputError=2;

    static void PrintErrorMessage(int ErrorType){
        if(ErrorType==NameInputError){
            System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
        if(ErrorType==TimeInputError){
            System.out.println("[ERROR] 사고 횟수는 숫자여야 합니다.");
        }
    }
}
