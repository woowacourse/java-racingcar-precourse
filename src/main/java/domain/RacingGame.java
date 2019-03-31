package domain;

import java.util.Scanner;

public class RacingGame {
    private Car[] cars;
    public RacingGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
        String userInput = scanner.nextLine();
        String[] carNames = inputCarName(userInput);
        while(!isCorrectInput(carNames)){
            System.out.println("잘못된 입력을 하셧습니다. 각 자동차의 이름은 5자이하여야 합니다.");
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은쉼표(,)기준으로구분)");
            userInput = scanner.nextLine();
            carNames = inputCarName(userInput);
        }

        cars = new Car[carNames.length];
        for(int i = 0 ; i < cars.length ; i++){
            cars[i]=  new Car(carNames[i]);
        }

        System.out.println("시도할 횟수는 몇회 인가요?");
        int count = scanner.nextInt();
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i < count ; i++){
            moveCars();
            System.out.println();
        }

        int maxPosition = getMaxPosition();
        String winner = getWinner(maxPosition);
        System.out.println(winner + "가 최종 우승 했습니다.");

    }

    public String[] inputCarName(String carNames){
        if(carNames == null){
            return new String[]{};
        }
        return carNames.split(",");
    }

    public boolean isCorrectInput(String[] carNames){
        for(String carName : carNames)
            if(carName.length() > 5 || carName.length() == 0){
                return false;
            }
        return true;
    }

    private void moveCars(){
        for(Car car : cars){
            car.move();
        }
    }

    private int getMaxPosition(){
        int result = cars[0].getPosition();
        for(int i = 1; i < cars.length ; i++){
            result = result < cars[i].getPosition() ? cars[i].getPosition() : result;
        }
        return result;
    }

    private String getWinner(int maxPosition){
        StringBuilder result = new StringBuilder();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                result.append(car.getName());
                result.append(", ");
            }
        }
        result.delete(result.length()-1 , result.length());
        return result.toString();
    }
}
