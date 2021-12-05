package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.GameTotalResultDto;

public class GameManagerTest {

    private final CustomNumberPicker customNumberPicker = new CustomNumberPicker();
    private final GameManager gameManager = new GameManager(customNumberPicker);

    @Test
    void 라운드단일실행_작동확인() {
        List<String> answers = Arrays.asList("개미 : _", "고양이 : _", "호랑이 : ");

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {9,5,1};
        int executionCount = 1;

        customNumberPicker.initNumber(numberPicks);
        gameManager.playGame(names, executionCount);

        GameTotalResultDto gameResult = gameManager.getGameTotalResult();
        assertThat(gameResult.getRoundResults().size()).isEqualTo(executionCount);

        List<String> roundStatus = gameResult.getRoundResults().get(0).getStatuses();
        assertThat(roundStatus.size()).isEqualTo(names.size());
        for (int i = 0; i < answers.size(); i++) {
            assertThat(roundStatus.get(i)).isEqualTo(answers.get(i));
        }
    }

    @Test
    void 라운드반복실행_작동확인() {
        List<String> answers = Arrays.asList(
            "개미 : ", "고양이 : _", "호랑이 : _",
            "개미 : _", "고양이 : __", "호랑이 : __",
            "개미 : _", "고양이 : __", "호랑이 : ___"
        );

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {3,4,5, 6,7,8, 1,2,9};
        int executionCount = 3;

        customNumberPicker.initNumber(numberPicks);
        gameManager.playGame(names, executionCount);

        GameTotalResultDto gameResult = gameManager.getGameTotalResult();
        assertThat(gameResult.getRoundResults().size()).isEqualTo(executionCount);

        for (int i = 0; i < executionCount; i++) {
            List<String> roundStatus = gameResult.getRoundResults().get(i).getStatuses();
            assertThat(roundStatus.size()).isEqualTo(names.size());

            for (int j = 0; j < names.size(); j++) {
                assertThat(roundStatus.get(j)).isEqualTo(answers.get(i * names.size() + j));
            }
        }
    }

    @Test
    void 우승자결정_작동확인() {
        List<String> answers = Arrays.asList("고양이", "호랑이");

        List<String> names = Arrays.asList("개미", "고양이", "호랑이");
        int[] numberPicks = new int[] {3,4,5, 6,7,8, 1,5,9};
        int executionCount = 3;

        customNumberPicker.initNumber(numberPicks);
        gameManager.playGame(names, executionCount);

        GameTotalResultDto gameResult = gameManager.getGameTotalResult();
        List<String> winners = gameResult.getWinners();

        assertThat(winners.size()).isEqualTo(answers.size());
        for (int i = 0; i< answers.size(); i++) {
            assertThat(winners.get(i)).isEqualTo(answers.get(i));
        }
    }

}
