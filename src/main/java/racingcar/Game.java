package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Game {
    private String input;
    public String[] carNames;
    public int times;
    public boolean checking;
    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList winner = new ArrayList<>();

    public Game() {

    }

    private void Input() {
        input = Console.readLine();
    }

    public void gameStart() {
        carInput();
        timesInput();
        createCars();
        gameTimes();
        checkWinner();
        showWinner();
    }

    public void carInput() {
        checking = false;
        while (!checking) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            Input();
            checking = checkCars();
        }
    }

    public void timesInput() {
        checking = false;
        while (!checking) {
            System.out.println("시도할 회수는 몇회인가요?");
            Input();
            checking = checkTimes();
        }
    }

    private boolean checkCars() {
        boolean checking = true;
        try {
            Exception e = new Exception();
            rightInput();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            checking = false;
        }
        return checking;
    }

    private void rightInput() throws IllegalArgumentException {
        carNames = input.split(",");
        for (int i=0;i<carNames.length; i++) {
            if (carNames[i].length() > 5 || carNames[i].length() == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean checkTimes() {
        try {
            Exception e = new Exception();
            rightInputTimes();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return false;
        }
        try {
            checkPositive();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 양수여야 한다.");
            return false;
        }
        return true;
    }

    private void rightInputTimes() throws IllegalArgumentException {
        char temp;
        for (int i=0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (Character.isDigit(temp) == false) {
                throw new IllegalArgumentException();
            }
        }
        if (input.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkPositive() throws IllegalArgumentException {
        times = Integer.parseInt(input);
        if (times < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void createCars() {
        for(int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    private void gameTimes() {
        System.out.println("실행 결과");
        for(int i = 0; i < times; i++) {
            gameProgress();
            printResult();
        }
    }

    private void gameProgress() {
        for(int i = 0; i < cars.size(); i++) {
            cars.get(i).stopOrGo();
        }
    }

    private void printResult() {
        for(int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i).getName() + " : ");
            for(int j = 0; j < cars.get(i).getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    private void checkWinner() {
        int max = 0;
        for(int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == max) {
                winner.add(cars.get(i).getName());
            }
            if (cars.get(i).getPosition() > max) {
                winner.clear();
                max = cars.get(i).getPosition();
                winner.add(cars.get(i).getName());
            }
        }
    }

    private void showWinner() {
        System.out.print("최종 우승자 : "+winner.get(0));
        for(int i = 1; i < winner.size(); i++) {
            System.out.print(", "+winner.get(i));
        }
    }



}
