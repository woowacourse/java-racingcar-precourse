package domain;


import java.util.ArrayList;
import java.util.Scanner;

public class GameFunction {

    private ArrayList<Car> carlist;
    private String setCarname = null;
    private String inputRound = null;
    private int winnerPoint = 0;

    public GameFunction() {
        carlist = new ArrayList<>();
    }

    public void initSetup() {

        while (!setCarname());

        while (!setRounds());

        createCar();

    }

    private boolean setCarname() {

        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");

        this.setCarname = scan.nextLine();
        String[] carNameSplit = this.setCarname.split(",");

        for (int i = 0; i < carNameSplit.length; i++) {
            if (carNameSplit[i].length() < 1 || carNameSplit[i].length() > 5)
                return false;
        }

        return true;
    }

    private boolean setRounds() {

        Scanner scan = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        this.inputRound = scan.nextLine();
        int num = 0;

        for (int i = 0; i < this.inputRound.length(); i++) {
            try {
                num = Integer.parseInt(inputRound);
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    public void createCar() {

        String[] carNameSplit = this.setCarname.split(",");

        for (int i = 0; i < carNameSplit.length; i++) {
            this.carlist.add(new Car(carNameSplit[i]));
        }

        System.out.println();
    }

    public void racing() {

        System.out.println("실행결과");

        for (int j = 0; j < carlist.size(); j++) {
            this.carlist.get(j).goAndStop();
            this.carlist.get(j).printDistance();
            this.winnerPoint = Math.max(this.winnerPoint, this.carlist.get(j).getPosition());
        }

        System.out.println();
    }

    public void checkWinner() {

        int manyPeople = 0;

        for (int i = 0; i < carlist.size(); i++) {

            if (this.winnerPoint == carlist.get(i).getPosition()) {

                if (manyPeople > 0) {
                    System.out.print(",");
                }

                System.out.print(carlist.get(i).getName());
                manyPeople++;
            }
        }

        System.out.println("가 최종 우승했습니다");

    }

    public String getCarname() {
        return setCarname;
    }

    public int getRounds() {
        return Integer.parseInt(inputRound);
    }
}