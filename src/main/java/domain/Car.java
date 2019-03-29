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
        String userInput;
        while(true)
        {
            System.out.print("경주할 자동차 이름을 입력하세요.");
            System.out.println(" 이름은 쉼표(,) 기준으로 구분합니다.");
            Scanner reader = new Scanner(System.in);
            userInput = reader.nextLine();
            if(userInput.length() >= 1)
            {
                break;
            }
        }
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

    private static boolean checkUserInput(String turns)
    {
        if(isNonNumberThere(turns))
        {
            return false;
        }
        return true;
    }

    private static boolean isNonNumberThere(String turns)
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

    public static void printMovements(Car[] cars)
    {
        for(int i=0; i<cars.length; i++)
        {
            System.out.print("" + cars[i].name + ":");
            for(int j=0; j<cars[i].position; j++)
            {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void announceWinners(Car[] cars)
    {
        ArrayList<Car> listOfCars = new ArrayList<Car>();
        int maxPosition = 0;
        for(int i=0; i<cars.length; i++)
        {
            if(cars[i].position > maxPosition)
            {
                maxPosition = cars[i].position;
            }
        }
        for(int i=0; i<cars.length; i++)
        {
            if(cars[i].position == maxPosition)
            {
                listOfCars.add(cars[i]);
            }
        }
        for(int i=0, n=listOfCars.size(); i<n-1; i++)
        {
            System.out.print("" + listOfCars.get(i).name);
            System.out.print(", ");
        }
        int lastIndex = listOfCars.size() - 1;
        System.out.println("" + listOfCars.get(lastIndex).name + "가 최종 우승했습니다.");
    }

    public static boolean getUserAnswer()
    {
        boolean result;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String strUserInput = scanner.nextLine();
            if (strUserInput.length() == 1 && strUserInput.charAt(0) == '1')
            {
                result = true;
                break;
            }
            if (strUserInput.length() == 1 && strUserInput.charAt(0) == '2')
            {
                result = false;
                break;
            }
        }
        return result;
    }
}
