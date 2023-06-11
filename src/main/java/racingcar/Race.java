package racingcar;

import java.util.*;
import java.util.stream.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Race
{
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";
    private static final String RESULT_HEAD = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String ERRMASSAGE = "[ERROR] 이름은 5글자 이하여야 합니다.";
    private static final String ERRROUNDMESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    private static Car[] cars;

    public void run()
    {
        String[] carnames = getCarsName();
        makeCars(carnames);

        int round = getRound();
        startRace(round);

        Car[] winners = calWinners();
        printWinnerName(winners);
    }
    private String[] getCarsName()
    {
        String[] carnames;
        while(true)
        {
            try
            {
                System.out.println(INPUT_NAME);
                carnames = readLine().split(",");
                validateNames(carnames);
                break;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return carnames;
    }
    private void makeCars(String[] carnames)
    {
        cars = Arrays.stream(carnames).map(Car::new).toArray(Car[]::new);
    }
    private int getRound()
    {
        System.out.println(INPUT_ROUND);
        String input;
        while(true)
        {
            try{
                input = readLine();
                validateRoundInput(input);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(input);
    }
    private void validateRoundInput(String input)
    {
        if(input.chars().allMatch(Character::isDigit))
            return;
        throw new IllegalArgumentException(ERRROUNDMESSAGE);
    }
    private void startRace(int round)
    {
        printResultHead();
        for(int i=0;i<round;i++)
        {
            moveCars();
            printRoundResult();
        }
    }
    private void printRoundResult()
    {
        for(Car car:cars)
            System.out.println(car.toString());
        System.out.println();
    }
    private void moveCars()
    {
        for(Car car:cars)
            car.start();
    }
    private void printResultHead()
    {
        System.out.println(RESULT_HEAD);
    }
    private Car[] calWinners()
    {
        int winnerDistance = getWinnerDistance();
        return getWinner(winnerDistance);
    }
    private int getWinnerDistance()
    {
        return Arrays.stream(cars).mapToInt(Car::getPosition).max().orElse(0);
    }
    private Car[] getWinner(int winnerDistance)
    {
        return Arrays.stream(cars).filter(car -> car.getPosition()==winnerDistance)
                .toArray(Car[]::new);
    }
    private void printWinnerName(Car[] winners)
    {
        System.out.println(FINAL_WINNER+getWinnerName(winners));
    }
    private String getWinnerName(Car[] winners)
    {
        return Arrays.stream(winners).map(Car::getName).collect(Collectors.joining(", "));
    }
    private boolean validateNameLength(String name)
    {
        return name.length() > 5;
    }
    private void validateNames(String[] carnames)
    {
        for(String carname:carnames)
        {
            if(validateNameLength(carname))
            {
                throw new IllegalArgumentException(ERRMASSAGE);
            }
        }
    }
}
