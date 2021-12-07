package racingcar.config;

import racingcar.service.SprintGameService;

public class ServiceConfig {

	public static SprintGameService getGameService() {
		return new SprintGameService(DomainConfig.getMovementStrategy());
	}
}
