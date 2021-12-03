package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Game;

public class GameRepository {
	private Long id = 0L;
	private final Map<Long, Game> games = new HashMap<>();

	public Long save(Game game) {
		Long returnId = id;
		games.put(id, game);
		id += 1;
		return returnId;
	}

	public Game findById(Long id) {
		return games.get(id);
	}

	public List<Game> findAll() {
		return new ArrayList<>(games.values());
	}
}
