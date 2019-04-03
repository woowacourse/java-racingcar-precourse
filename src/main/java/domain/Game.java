package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private static final int TURN_END_LIMIT = 0;
    private Car[] cars;
    private Display display;

    public Game() {
        display = new Display();
    }

    public void initGame() {
        String[] names = display.getNames();
        cars = new Car[names.length];
        makeCars(names);
        int trialNumbers = display.getTrialNumbers();
        System.out.println("실행 결과");
        playGames(trialNumbers);
    }

    public Car[] makeCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        return cars;
    }

    public void goOneTurnForEachCar() {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = cars[i].makeRandomNums();
            cars[i].increasePosition(randomNum);
            display.showResults(cars[i]);
        }
    }

    public void decidesWinner() {
        /*cars배열은 정렬되어 있기 때문에 첫번째 Car가 position이 최대인 Car이다.*/
        int maxPosition = cars[0].getPosition();
        ArrayList<String> ans = new ArrayList<String>();
        ans.add(cars[0].getName());
        for (int i = 1; i < cars.length; i++) {
            /*이미 정렬되어 있는 배열이기 때문에 maxPosition과 position값이 다르면 position이 maxPosition보다 작은 값이다.*/
            if (maxPosition != cars[i].getPosition()) {
                break;
            }
            ans.add(cars[i].getName());
        }
        display.showWinners(ans);
    }

    public void playGames(int turns) {
        while (turns > TURN_END_LIMIT) {
            goOneTurnForEachCar();
            System.out.println();
            turns--;
        }
        Arrays.sort(cars);
        decidesWinner();
    }
}
