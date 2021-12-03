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
        printResult();
    }
    private void printResult(){
        int maxValue = findMaxPosition();
        System.out.print("최종 우승자 : ");
        List<String> winners = new ArrayList<>();
        carList.stream().filter(car -> car.getPosition() == maxValue).forEach(car -> winners.add(car.getName()));
        int winnerNumber  = winners.size();
        for(int i = 0 ; i < winnerNumber; i++){
            System.out.print(winners.get(i));
            if(i != winnerNumber -1) System.out.print(", ");
        }
    }
    private int findMaxPosition(){
        int maxValue = -1;
        int carsNumber = carList.size();
        for (int i = 0; i<carsNumber;  i++ ){
            int position = carList.get(i).getPosition();
            if(maxValue < position) maxValue = position;
        }
        return maxValue;
    }
    private void play(){
        for(int i = 0 ; i < tryNumber ; i++ ){
            increaseCarsPosition();
            printExecutionResult();
        }
    }
    private void printExecutionResult(){
        System.out.println("실행 결과");
        carList.forEach((car) -> {
            System.out.print(car.getName()+" : ");
            int position = car.getPosition();
            for (int i = 0 ; i < position; i++){
                System.out.print("-");
            }
            System.out.println();
        });
        System.out.println();
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
        carList = cars;
    }
    private List<String> getCarNamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (true){
            String inputCarNames = Console.readLine();
            try{
                return  inputValidator.validateCarName(inputCarNames);
            }catch (Exception e){
                System.out.println("[ERROR] 잘못된 자동차 이름입니다! 1~5글자여야 합니다.");
            }
        }
    }
    private int getTryNumberFromUser(){
        System.out.println("시도할 회수는 몇회인가요?");
        while (true){
            String tryNumber = Console.readLine();
            try{
                return inputValidator.validateTryNumber(tryNumber);
            }catch (Exception e){
                System.out.println("[ERROR] 횟수는 0 이상의 정수로만 입력해주세요");
            }
        }
    }
}
