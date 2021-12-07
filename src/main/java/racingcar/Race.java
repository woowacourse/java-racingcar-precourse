package racingcar;

public class Race {

    public static void generateCarName(User user) {
        while (true) {
            try {
                System.out.println(Constant.INPUT_MESSAGE_CAR_NAME);
                user.enterCarName();
                user.toNameArray();
                CarNameException.validateCarName(user.getCarName());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
