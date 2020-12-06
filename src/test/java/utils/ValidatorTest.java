package utils;

import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidNameException;
import racingcar.exception.InvalidNumberException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    public void test1(){

        String input = "aaa,     ,\t ,ccccc ,ddddd";

        String[] strings = Stream.of(input.split(","))
                .toArray(String[]::new);

        Arrays.stream(strings)
                .forEach(System.out::println);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "홍길동, 임꺽정, 스터디,카페이"
            , "다섯글자, 넘지말자, 그러면성공"
            , "1234,숫자도,가능하다,이름으로,사용가능하"
    })
    @Description("입력으로 들어온 문자열이 유요한 이름인지 확인하는 테스트, 아무것도 발생안해야 성공")
    public void validateNamesTest(String inputs) {

        //given
        String[] names = Stream.of(inputs.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        //when
        Validator.validateNames(names);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "난여섯글자다, 123456, 불가능하다"
            , "동명이인, 동명이인, 동명삼인"
            , "   ,         ,      ,\t  "
    })
    @Description("입력으로 들어온 문자열이 유요한 이름인지 확인하는 테스트, 예외 발생해야 성공")
    public void validateNamesTestFail(String inputs) {

        //given
        String[] names = Stream.of(inputs.split(","))
                .map(String::trim)
                .toArray(String[]::new);

        //when
        assertThrows(InvalidNameException.class, () -> {

            //then
            Validator.validateNames(names);
        });

    }

    @Test
    @Description("입력 값 중에서 중복된 이름이 있는지 체크한다.")
    public void hasDuplicateTest() throws NoSuchMethodException {

        //given
        String input = "aaa,bbb,ccc,ddd,eee";   //
        Validator validator = new Validator();
        Method method = Validator.class.getDeclaredMethod("hasDuplicate", String[].class);
        method.setAccessible(true);
        //when

    }

    @Test
    public void isNumberTypeTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //given
        Validator validator = new Validator();
        Method method = getReflectMethod("isNumberType", String.class);

        //when
        String input = "10";
        String input2 = "ten";
        boolean result = (boolean) method.invoke(validator, input);
        boolean result2 = (boolean) method.invoke(validator, input2);

        //then
        assertTrue(result);
        assertFalse(result2);

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "100", "99"})
    @Description("0이상의 정수만 입력해야 테스트 통과, 다른 경우는 IllegalArgumentException(미정)이 발생")
    public void validateRepeatTest(String input) throws NoSuchMethodException, InvocationTargetException
            , IllegalAccessException {

        //given
        Validator validator = new Validator();
        Method method = getReflectMethod("validateRepeat", String.class);

        //when
        Object invoke = method.invoke(validator, input);

        //then  아무일도 발생하지 않는다.

    }


    /*
     *  TODO 예외는 정삭적으로 발생하나 reflection을 이용한 테스트라서,
     *   InvocationTargetException예외가 발생 테스트케이스 수정
     */
    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-300", "3.2"})
    @Description("0이상의 정수만 입력해야 테스트 통과, 다른 경우는 IllegalArgumentException(미정)이 발생")
    public void validateRepeatTestFail(String input) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        //given
        Validator validator = new Validator();
        Method method = getReflectMethod("validateRepeat", String.class);


        //when
        assertThrows(InvalidNumberException.class, () -> {
            method.invoke(validator, input);
        });

    }

    public Method getReflectMethodAndInvoke(String methodName, Class<?> argType, Object obj
            , Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getDeclaredMethod(methodName, argType);
        method.setAccessible(true);

        method.invoke(obj, args);

        return method;
    }


    public Method getReflectMethod(String methodName, Class<?> argType) throws NoSuchMethodException {
        Method method = Validator.class.getDeclaredMethod(methodName, argType);
        method.setAccessible(true);
        return method;
    }


}