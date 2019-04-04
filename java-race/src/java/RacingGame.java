package java;

import domain.Car;

import java.util.ArrayList;
import java.util.Scanner;


public class RacingGame {
	 private Scanner sc = new Scanner(System.in);
	    private ArrayList<Car> carList = new ArrayList<>();

	    public void inputCarName() throws Exception {
	        final String delimiter = ",";
	        final String exceptionMessage = "�ڵ����� �̸��� 5�� ���ϸ� �����մϴ�.";

	        String userInput = sc.nextLine();
	        String[] carNames = userInput.split(delimiter);

	        for (int i = 0; i < carNames.length; i++) {
	            if (carNames[i].length() > 5) {
	                throw new Exception(exceptionMessage);
	            }
	            carList.add(new Car(carNames[i]));
	        }
	    }
}
