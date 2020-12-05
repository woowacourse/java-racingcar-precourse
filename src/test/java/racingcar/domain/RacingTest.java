package racingcar.domain;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.lang.reflect.Field;
import java.util.List;

class RacingTest {

    @Test
    @Description("Racing 생성 테스트, 이름이 N개 들어가있다면 Racing List<Car>의 Size가 N개")
    public void createRacingTest() throws NoSuchFieldException, IllegalAccessException {

        //given
        String[] names = new String[]{"a", "b", "c", "d"}; // 4개
        Racing racing = Racing.create(names);

        //when
        Field cars = Racing.class.getDeclaredField("cars");
        cars.setAccessible(true);

        List<Car> result = (List<Car>) cars.get(racing);

        //then
        Assertions.assertTrue(result.size() == names.length);

    }

    @Test
    @Description("메서드 실행후, List에 있는 Cars의 positon이 증가해야한다.")
    public void moveCarsTest() throws NoSuchFieldException, IllegalAccessException {

        //given
        Racing racing = createTest();
        Car positionZero = Car.createNameBy("positionZero");        //position == 0인 테스트 객체 생성
        //when
        racing.moveCars();
        Field cars = Racing.class.getDeclaredField("cars");
        cars.setAccessible(true);
        List<Car> carList = (List<Car>) cars.get(racing);

        //then
        boolean result = carList.stream()
                .anyMatch(car -> car.compareTo(positionZero) > 0
                );

        Assertions.assertTrue(result);

    }

    @Test
    @Description("Car.create() 생성시 이름을 1개 이상 보내야된다. 그렇지 않으면 예외발생")
    public void carCreateExceptionTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Racing.create();
        });

    }

    @Test
    @Description("모든 턴을 완료한 후, 1등을 반환해야한다.")
    public void getFirstTest() throws NoSuchFieldException, IllegalAccessException {

        //given
        Racing racing = createTest();
        for (int i = 0; i < 5; i++) { // 5번 moveCars 실행 후 결과값을 기준으로 테스트
            racing.moveCars();
        }
        //when

        Field getCars = Racing.class.getDeclaredField("cars");
        getCars.setAccessible(true);
        List<Car> cars = (List<Car>) getCars.get(racing);   //강제로 빼온 Cars
        cars.sort(Car::compareTo);

        List<Car> winners = racing.getWinners();    // Winner 하나 이상은 들어있다.
        Car winnerCar = winners.get(0);
        Car carsFirst = cars.get(cars.size() - 1);

        //then
        Assertions.assertTrue(winnerCar.compareTo(carsFirst) == 0);

    }

    @Test
    @Description("toString으로 List<Car>안에 있는 자동차들의 위치를 출력, 직접 보는 용도")
    public void toStringTest() {

        Racing racing = createTest();

        racing.moveCars();

        String resultMessage = racing.toString();

        System.out.println(resultMessage);


    }

    private static Racing createTest() {

        String[] names = new String[]{"a", "b", "c", "d", "e", "f", "g"};

        return Racing.create(names);
    }

}