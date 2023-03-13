package racingcar.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Exceptions.CarsDuplicatedNameException;
public class Cars {

    private final List<Car> cars;

    private static final String DELIMITER = ",";
    private static final String DUPLICATED_DELIMITER_REGEX = ",+";

    private Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }
    public static Cars createCarByName(String input) {
        List<Car> cars  = new ArrayList<>();
        String[] words = divideWord(input);

        checkValidateName(words);

        for(String name : words){
            cars.add(new Car(name));
        }
        return new Cars(cars); // 방어적 복사

    }
    private static String[] divideWord(String word){
        return word.replaceAll(DUPLICATED_DELIMITER_REGEX, DELIMITER).split(DELIMITER);
    }
    private static void checkValidateName(String[] words){

        validateDuplicateName(words);
    }
    private static void validateDuplicateName(String[] names){
        Set<String> uniqueWord = new HashSet<>();
        for(String name : names){
            if(!uniqueWord.add(name)){
                throw new CarsDuplicatedNameException();
            }
        }
    }

    public  void move() {
        for(Car car : cars){
            car.move(Randoms.pickNumberInRange(0,9));
        }
    }
    public List<Car> getCars(){
        return this.cars;
    }
}
