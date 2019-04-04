package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingGame {

    private String carNames;
    private Car[] cars;
    private int racingCnt;
    private int maxPosition;
    private BufferedReader br;

    public RacingGame() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean setCarNames() {
        this.showMessage("경주할 자동차의 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            String inputCarNames = br.readLine();
            if (isValidateCarNames(inputCarNames)) {
                this.carNames = inputCarNames;
                return true;
            }
            this.showMessage("유효하지 않은 입력, 이름은 5자 이하입니다.");
        } catch (Exception e) {
            this.showMessage("입력 오류 입니다.");
        }

        return false;
    }

    public boolean isValidateCarNames(String inputCarNames) {
        boolean isValidate = true;
        for (String carName : inputCarNames.split(",")) {
            if (carName.length() > 5) {
                isValidate = false;
                break;
            }
        }
        return isValidate;
    }

    public void createCars() {
        String[] carNamesArr = this.carNames.split(",");
        int carCnt = carNamesArr.length;
        this.cars = new Car[carCnt];

        for (int i = 0; i < carCnt; i++) {
            this.cars[i] = new Car(carNamesArr[i]);
        }
    }

    public boolean setRacingCount() {
        this.showMessage("시도할 회수는 몇회인가요?");

        try {
            String inputRacingCnt = br.readLine();
            if (isValidateRacingCount(inputRacingCnt)) {
                racingCnt = Integer.parseInt(inputRacingCnt);
                return true;
            }
            this.showMessage("유효하지 않은 입력 입니다.");
        } catch (Exception e) {
            this.showMessage("입력 오류 입니다.");
        }

        return false;
    }

    public boolean isValidateRacingCount(String inputRacingCount) {
        try {
            Integer.parseInt(inputRacingCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void setMaxPosition(int position) {
        this.maxPosition = position;
    }

    public void init() {
        while (!this.setCarNames()) ;
        this.createCars();
        while (!this.setRacingCount()) ;
        this.setMaxPosition(0);
    }

    public void doRacing() {
        for (int i = 0; i < this.cars.length; i++) {
            Car car = this.cars[i];
            car.race();

            int newPosition = car.getPosition();
            if (newPosition > this.maxPosition) {
                this.setMaxPosition(newPosition);
            }

            this.showCarStatus(car.getName(), newPosition);
        }
    }

    public void showCarStatus(String name, int newPosition) {
        this.showMessage(name + ": " + makePositionToDash(newPosition));
    }

    public String makePositionToDash(int position) {
        String dash = "";
        for (int index = 0; index < position; index++) {
            dash += "-";
        }
        return dash;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }


}
