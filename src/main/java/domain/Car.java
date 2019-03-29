package domain;
import java.util.*;

public class Car
{
    private final String name;
    private int position = 0;

    public Car(String name)
    {
        this.name = name;
    }

    public static String[] getCarNames()
    {
        System.out.print("경주할 자동차 이름을 입력하세요.");
        System.out.println(" 이름은 쉼표(,) 기준으로 구분합니다.");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        userInput = userInput.replaceAll("\\s+", "");
        String[] userInputArray = userInput.split(",");
        return userInputArray;
    }

    public static int askHowManyTurns()
    {
        String turns;
        while (true)
        {
            System.out.println("시도할 회수는 몇회인가요?");
            Scanner reader = new Scanner(System.in);
            turns = reader.nextLine();
            boolean isUserInputRight = checkUserInput(turns);
            if(isUserInputRight)
            {
                break;
            }
        }
        return Integer.parseInt(turns);
    }

}
