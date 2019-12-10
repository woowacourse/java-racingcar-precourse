//package view;
//
//import static org.junit.Assert.assertTrue;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//
//import annotation.TestDescription;
//import domain.model.Car;
//import domain.model.Vehicle;
//import org.junit.Test;
//
//public class UserInputTest {
//
//    @Test
//    @TestDescription("유저의 입력에 맞게, 적절한 자동차 객체가 생성되어 리스트에 담겨 반환되는 지 테스트")
//    public void carNameToCarListTest() throws IOException {
//        UserInput userInput = new UserInput();
//        List carList = userInput.carNameToCarList(new String[]{"name", "young", "kim"});
//
//        Iterator carIterator = carList.iterator();
//        while (carIterator.hasNext()) {
//            Object next = carIterator.next();
//            assertTrue(next instanceof Vehicle && next instanceof Car);
//        }
//        assertTrue(carList.size() == 3);
//    }
//}