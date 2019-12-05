package domain;

public class Car {
    private static final String SPACING_WORDS = " : ";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static void makeResult(Car user, boolean goOrStop) {
        if(goOrStop){
            user.position++;
        }
    }

}
