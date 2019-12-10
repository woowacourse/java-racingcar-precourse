//package domain.model;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import annotation.TestDescription;
//import org.junit.Test;
//
//public class WinnerTest {
//
//    @Test
//    @TestDescription("getWinner()메소드의 return값이 승자를 모두 담아 정상적으로 리턴하는지 테스트")
//    public void getWinnerTest() {
//
//        /* position 값이 가장 큰 객체가 하나 일 때 */
//        List<Car> users = new ArrayList<>();
//        users.add(new Car("name"));
//        users.add(new Car("hello"));
//        users.add(new Car("world"));
//        users.get(0).goForwardPosition(true, users.get(0));
//        users.get(0).goForwardPosition(true, users.get(0));
//        users.get(1).goForwardPosition(true, users.get(1));
//        Winner winner = new Winner();
//        List<String> winner1 = winner.getWinner(users);
//        assertTrue(winner1.contains(users.get(0).getName()));
//        assertFalse(winner1.contains(users.get(1).getName()));
//        assertFalse(winner1.contains(users.get(2).getName()));
//
//        /* position 값이 가장 큰 객체가 둘 이상일 때 */
//        List<Car> users2 = new ArrayList<>();
//        users2.add(new Car("name"));
//        users2.add(new Car("hello"));
//        users2.add(new Car("world"));
//        users2.get(0).goForwardPosition(true, users2.get(0));
//        users2.get(0).goForwardPosition(true, users2.get(0));
//        users2.get(1).goForwardPosition(true, users2.get(1));
//        users2.get(1).goForwardPosition(true, users2.get(1));
//        List<String> winner2 = winner.getWinner(users2);
//        assertTrue(winner2.contains(users2.get(0).getName()));
//        assertTrue(winner2.contains(users2.get(1).getName()));
//        assertFalse(winner2.contains(users2.get(2).getName()));
//
//        /* position 값이 가장 큰 객체가 없을 때 (0으로 모두 동일 한 경우) */
//        List<Car> users3 = new ArrayList<>();
//        users3.add(new Car("name"));
//        users3.add(new Car("hello"));
//        users3.add(new Car("world"));
//        List<String> winner3 = winner.getWinner(users3);
//        assertTrue(winner3.contains(users3.get(0).getName()));
//        assertTrue(winner3.contains(users3.get(1).getName()));
//        assertTrue(winner3.contains(users3.get(2).getName()));
//
//    }
//
//
//}