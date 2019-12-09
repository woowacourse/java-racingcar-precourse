package ui;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import domain.RacingGameConfig;
import domain.Validator;
import util.RacingPrinter;



import static org.junit.jupiter.api.Assertions.*;



class ConsoleTest {

    private Console console;
    private Scanner scanner;
    private InputController inputController;
    private Validator mockValidator = mock(Validator.class);
    private RacingPrinter mockRacingPrinter = mock(RacingPrinter.class);

    @AfterEach
    void clear() {
        try {
            if (scanner != null) {
                scanner.close();
            }
        } catch (RuntimeException e) {
            System.out.println(String.format("테스트 중 다음과 같은 오류로 시스템을 종료합니다 : %s", e.getMessage()));
            System.exit(-1);
        }
    }

    @Test
    void extractNamesWithValidInputs() {
        //given
        String input = "pobi,crong,honux";
        console = createConsoleForTest(input);
        String[] result = {"pobi", "crong", "honux"};
        when(mockValidator.validateNames(any())).thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());

        //given
        input = " pobi,crong,honux ";
        console = createConsoleForTest(input);
        //when & then
        assertArrayEquals(result, console.extractNames());
    }

    @Test
    void extractNamesWithTooLongNames() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String tooLongName = StringUtils.repeat("a", RacingGameConfig.MAX_NAME_LENGTH + 1);
        String normalNames = "pobi,crong,honux";
        String[] result = {"pobi", "crong", "honux"};
        when(inputController.nextLine())
                .thenReturn(tooLongName)
                .thenReturn(normalNames);
        when(mockValidator.validateNames(any()))
                .thenReturn(false)
                .thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());
        verify(mockRacingPrinter).printErrorWhenExtractingNames(any());

    }

    @Test
    void extractNamesWithNotAllowdCharacter() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String namesWithNotAllowedCharacter = "pobi,crong,hon*ux";
        String normalNames = "pobi,crong,honux";
        String[] result = {"pobi", "crong", "honux"};
        when(inputController.nextLine())
                .thenReturn(namesWithNotAllowedCharacter)
                .thenReturn(normalNames);
        when(mockValidator.validateNames(any()))
                .thenReturn(false)
                .thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());
        verify(mockRacingPrinter).printErrorWhenExtractingNames(any());
    }

    @Test
    void extractNamesWithSpace() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String namesWithSpace = "pobi, crong,honux";
        String normalNames = "pobi,crong,honux";
        String[] result = {"pobi", "crong", "honux"};
        when(inputController.nextLine())
                .thenReturn(namesWithSpace)
                .thenReturn(normalNames);
        when(mockValidator.validateNames(any()))
                .thenReturn(false)
                .thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());
        verify(mockRacingPrinter).printErrorWhenExtractingNames(any());
    }

    @Test
    void extractNamesWithSeparatorsAtFirstAndLast() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String namesWithSperatorsAtFirstAndLast = ",pobi,crong,honux,";
        String normalNames = "pobi,crong,honux";
        String[] result = {"pobi", "crong", "honux"};
        when(inputController.nextLine())
                .thenReturn(namesWithSperatorsAtFirstAndLast)
                .thenReturn(normalNames);
        when(mockValidator.validateNames(any()))
                .thenReturn(true);
        //when & then
        assertArrayEquals(result, console.extractNames());
        verify(mockRacingPrinter).printErrorWhenExtractingNames(any());
    }

    @Test
    void getCyclesWitchValidInput() {
        //given
        String input = "1";
        console = createConsoleForTest(input);
        when(mockValidator.validateCycles(anyInt())).thenReturn(true);
        //when & then
        assertEquals(Integer.parseInt(input), console.getCycles());
    }

    @Test
    void getCyclesWithTooSmallInput() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String tooSmallInput = String.valueOf(RacingGameConfig.MIN_CYCLES - 1);
        String normalInput = "1";
        when(inputController.nextLine())
                .thenReturn(tooSmallInput)
                .thenReturn(normalInput);
        when(mockValidator.validateCycles(anyInt()))
                .thenReturn(false)
                .thenReturn(true);
        //when & then
        assertEquals(Integer.parseInt(normalInput), console.getCycles());
        verify(mockRacingPrinter).printErrorWithTooSmallCycle(anyInt());
    }

    @Test
    void getCyclesWithNotNaturalInput() {
        //given
        console = createConsoleWithMockInputControllerForTest();
        String alphabetInput = "a";
        String normalInput = "1";
        when(inputController.nextLine())
                .thenReturn(alphabetInput)
                .thenReturn(normalInput);
        when(mockValidator.validateCycles(anyInt()))
                .thenReturn(true);

        //when & then
        assertEquals(Integer.parseInt(normalInput), console.getCycles());
        verify(mockRacingPrinter).printErrorWithNotNaturalNumber();
    }

    private Console createConsoleForTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        scanner = new Scanner(System.in);
        inputController = new InputControllerImpl(scanner);
        return new Console(inputController, mockValidator, mockRacingPrinter);
    }

    private Console createConsoleWithMockInputControllerForTest() {
        inputController = mock(InputController.class);
        return new Console(inputController, mockValidator, mockRacingPrinter);
    }
}