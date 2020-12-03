package racingcar;

import utils.Printer;
import utils.Validator;
import java.util.*;

public class CarRacingGame {
    private CarList carList;
    private int playRound;
    private Validator validator = new Validator();

    public CarRacingGame() {
        carList = new CarList();
        playRound = 0;
    }

    public void inputInfoForPlayGame(Scanner scanner)
    {
        carList.setCarList(inputCarName(scanner));
        playRound = inputPlayRound(scanner);
    }

    public List<String> inputCarName(Scanner scanner) {
        try {
            Printer.setCarNamePrinter();
            List<String> carList = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            validator.isValidCarName(carList);
            return carList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarName(scanner);
        }
    }

    public int inputPlayRound(Scanner scanner) {
        try {
            Printer.setPlayRoundPrinter();
            String playRound = scanner.nextLine();
            validator.isPlayRoundInteger(playRound);
            return Integer.parseInt(playRound);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayRound(scanner);
        }
    }


    //나중에 삭제할 메소드
    public void inputTest() {
        System.out.println("--------------");
        System.out.println("입력값 테스트");
        for (Car car : carList.getCarList())
        {
            System.out.print(car.getName() + " ");
        }
        System.out.println();
        System.out.println(playRound);
        System.out.println("--------------");
    }


}
