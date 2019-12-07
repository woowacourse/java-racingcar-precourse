import java.util.Scanner;

public class CarRaceGame {
	public static void main(String[] args) {
		String testString;
		Scanner sc = new Scanner(System.in);
		testString = sc.nextLine();
		String[] testStringrtn = UtilityMethods.sliceString(testString);
		for (int i = 0; i < testStringrtn.length; i++) {
			System.out.println(testStringrtn[i]);
		}
	}
}
