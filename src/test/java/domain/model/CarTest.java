//package domain.model;
//
//import static org.junit.Assert.*;
//
//import annotation.TestDescription;
//import org.junit.Test;
//
//public class CarTest {
//
//    @Test
//    @TestDescription("프로그램 전반에 걸쳐 Vehicle을 상속받는 제네릭 T를 사용하고 있기에 자동차 객체 생성시, Vehicle, Car 모두의 인스턴스 인지 테스트")
//    public void carAndVehicleTest() {
//        assertTrue(new Car("name") instanceof Vehicle);
//        assertTrue(new Car("name") instanceof Car);
//    }
//}