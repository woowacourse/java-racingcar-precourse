package racingcar.service;

import java.util.List;

import racingcar.domain.Player;

public interface JudgmentService {

    public List<String> judgeTheWinner(Player player);
}
