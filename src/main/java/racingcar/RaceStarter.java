package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RaceStarter {
    InputValidator inputValidator = new InputValidator();
    List<Car> carList;
    int tryNumber=0;
    public RaceStarter() {

    }
    public void start(){
        List<String> carNameList = getCarNamesFromUser();
        tryNumber = getTryNumberFromUser();
        initCarList(carNameList);
        play();

    }
    private void play(){
        for(int i = 0 ; i < tryNumber ; i++ ){
            increaseCarsPosition();
            printExecutionResult();
        }
    }
    private void printExecutionResult(){
        carList.forEach(car -> {
            System.out.print(car.getName()+" : ");
            int position = car.getPosition();
            for (int i = 0 ; i < position; i++){
                System.out.print("-");
            }
        });
    }
    private void increaseCarsPosition(){
        carList.forEach(car -> {
            int random = Randoms.pickNumberInRange(0,9);
            if(random >=4) car.increasePosition();
        });
    }
    private void initCarList(List<String> carNamesList){
        List<Car> cars = new ArrayList<>();
        carNamesList.forEach((carName)->{
            Car car = new Car(carName);
            cars.add(car);
        });
    }
    private List<String> getCarNamesFromUser(){
        while (true){
            String inputCarNames = Console.readLine();
            try{
                return  inputValidator.validateCarName(inputCarNames);
            }catch (Exception e){
                System.out.println("[ERROR] 잘못된 자동차 이름입니다!");
            }
        }
    }
    private int getTryNumberFromUser(){
        while (true){
            String tryNumber = Console.readLine();
            try{
                return inputValidator.validateTryNumber(tryNumber);
            }catch (Exception e){
                System.out.println("[ERROR] 잘못된 자동차 이름입니다!");
            }
        }
    }
}
