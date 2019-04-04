import domain.Car;
import domain.Player;

import java.util.ArrayList;

public class PlayerTest {
    public static void main(String[] args) {
        Player user = new Player();
        PlayerTest.testIsValidCarName(user);
        PlayerTest.testCreateCars(user);
    }

    private static void testCreateCars(Player user) {
        String[][] testCases = {
            {"pobi", "conan"},
            {"good", "bad"},
            {"oh", "yes"},
        };
        for (int i = 0; i < testCases.length; i++) {
            ArrayList<Car> cars = user.createCars(testCases[i]);
            for (int j = 0; j < cars.size(); j++) {
                String carName = cars.get(j).getName();
                assert (carName.equals(testCases[i][j]));
            }
        }
    }

    private static void testIsValidCarName(Player user) {
        String[][] passCases = {
            {"pobi", "conan"},
            {"good", "bad"},
            {"oh", "yes"},
        };
        String[][] nonPassCases = {
            {"pobiii", "conannn"},
            {"gooddd", "badddd"},
            {"chaehwan", "sayhello"},
        };
        for (int i = 0; i < passCases.length; i++) {
            assert (user.isValidCarName(passCases[i]));
        }
        for (int i = 0; i < nonPassCases.length; i++) {
            assert (!user.isValidCarName(nonPassCases[i]));
        }
    }
}
