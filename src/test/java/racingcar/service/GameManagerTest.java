package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class GameManagerTest {

    private final CustomNumberPicker customNumberPicker = new CustomNumberPicker();
    private final GameManager gameManager = new GameManager(customNumberPicker);

    @Test
    void 라운드단일실행_작동확인() {
        List<String> answers = Arrays.asList("개미 : _", "고양이 : _", "호랑이 : ");

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {9,5,1};

        customNumberPicker.initNumber(numberPicks);
        gameManager.registerNames(names);
        gameManager.playRound();

        List<String> statuses = gameManager.getStatuses();
        assertThat(statuses.size()).isEqualTo(answers.size());
        for (int i = 0; i < answers.size(); i++) {
            assertThat(statuses.get(i)).isEqualTo(answers.get(i));
        }
    }

    @Test
    void 라운드반복실행_작동확인() {
        List<String> answers = Arrays.asList("개미 : _", "고양이 : __", "호랑이 : ___");

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {3,4,5, 6,7,8, 1,2,9};
        int executionCount = 3;

        customNumberPicker.initNumber(numberPicks);
        gameManager.registerNames(names);
        for (int i = 0; i < executionCount; i++) {
            gameManager.playRound();
        }

        List<String> statuses = gameManager.getStatuses();
        assertThat(statuses.size()).isEqualTo(answers.size());
        for (int i = 0; i< answers.size(); i++) {
            assertThat(statuses.get(i)).isEqualTo(answers.get(i));
        }
    }

    @Test
    void 우승자결정_작동확인() {
        List<String> answers = Arrays.asList("고양이", "호랑이");

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {3,4,5, 6,7,8, 1,5,9};
        int executionCount = 3;

        customNumberPicker.initNumber(numberPicks);
        gameManager.registerNames(names);
        for (int i = 0; i < executionCount; i++) {
            gameManager.playRound();
        }

        List<String> winners = gameManager.getWinners();
        assertThat(winners.size()).isEqualTo(answers.size());
        for (int i = 0; i< answers.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(answers.get(i));
        }
    }

}
