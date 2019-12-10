//package domain.model;
//
//import static org.junit.Assert.assertEquals;
//
//import annotation.TestDescription;
//import org.junit.Test;
//
//public class VehicleTest {
//    private static final int ENOUGH_BIG_NUMBER = 1000000;
//
//    @Test
//    @TestDescription("자동차 클래스에서 생성자와, Getter 및 포지션 이동 및 출력이 잘 되는지 테스트")
//    public void VehicleConstructorAndGetterTest() {
//        Vehicle car = new Car("name");
//        for (int i = 0; i < 4; i++) {
//            car.goForwardPosition(true, car);
//        }
//        car.goForwardPosition(false, car);
//        assertEquals(car.getName(), "name");
//        assertEquals(car.getPosition(), 4);
//        assertEquals(car.toString(),
//                car.getName() + " : " + "----");
//
//        Car car2 = new Car("name");
//        for (int i = 0; i < ENOUGH_BIG_NUMBER; i++) {
//            car2.goForwardPosition(true, car);
//            car2.goForwardPosition(false, car);
//        }
//        assertEquals(car2.getPosition(), ENOUGH_BIG_NUMBER);
//    }
//}
