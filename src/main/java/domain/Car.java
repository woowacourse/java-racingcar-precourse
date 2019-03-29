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

    public static boolean checkUserInput(String turns)
    {
        if(isNonNumberThere(turns))
        {
            return false;
        }
        return true;
    }

    public static boolean isNonNumberThere(String turns)
    {
        for(int i=0, n = turns.length(); i<n; i++)
        {
            if (!(Character.isDigit(turns.charAt(i))))
            {
                System.out.println("정수인 숫자만 입력해주세요!");
                return true;
            }
        }
        return false;
    }

    public static Car[] instantiateAndReturn(String[] carNames)
    {
        Car[] cars = new Car[carNames.length];
        for(int i=0; i < carNames.length; i++)
        {
            cars[i] = new Car(carNames[i]);
        }
        return cars;
    }

    public static void moveCars(Car[] cars)
    {
        for(int i=0; i<cars.length; i++)
        {
            int distance = 0;
            int randomNumber = (int) (Math.random()*10);
            if (randomNumber >= 4)
            {
                distance = 1;
            }
            cars[i].position += distance;
        }
    }
}
