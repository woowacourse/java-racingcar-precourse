package racingcar;

import utils.Printer;
import utils.Validator;

import java.util.*;

public class CarRacingGame {
    private List<Car> carList;
    private int playRound;

    public CarRacingGame(List<String> inputList, int playRound) {
        carList = new ArrayList<>();
        setCarList(inputList);
        this.playRound = playRound;
    }

    public static CarRacingGame inputInfoForPlayGame(Scanner scanner)
    {
        Validator validator = new Validator();
        try {
            Printer.setCarNamePrinter();
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            validator.isValidCarName(carList);
            Printer.setPlayRoundPrinter();
            String playRound = scanner.nextLine();
            validator.isPlayRoundInteger(playRound);
            return new CarRacingGame(carList, Integer.parseInt(playRound));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return inputInfoForPlayGame(scanner);
        }
    }

    public void setCarList(List<String> inputList) {
        for (String car : inputList) {
            carList.add(new Car(car));
        }
    }




    //나중에 삭제할 메소드
    public void inputTest() {
        System.out.println("--------------");
        System.out.println("입력값 테스트");
        for (Car car : carList)
        {
            System.out.print(car.getName() + " ");
        }
        System.out.println();
        System.out.println(playRound);
        System.out.println("--------------");
    }


}
