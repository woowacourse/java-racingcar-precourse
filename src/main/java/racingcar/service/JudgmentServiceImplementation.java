package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import racingcar.domain.Car;
import racingcar.domain.Player;

public class JudgmentServiceImplementation implements JudgmentService {

    private final Comparator<Car> carDistanceDescending;

    public JudgmentServiceImplementation(Comparator<Car> carDistanceDescending) {
        this.carDistanceDescending = carDistanceDescending;
    }

    @Override
    public List<String> judgeTheWinner(Player player) {
        List<String> winners = new ArrayList<>();
        int farthestDistance = 0;
        PriorityQueue<Car> priorityQueue = enqueuePriorityQueue(player);
        while (!priorityQueue.isEmpty() && farthestDistance <= priorityQueue.peek().getPosition()) {
            Car farthestCar = priorityQueue.poll();
            farthestDistance = farthestCar.getPosition();
            winners.add(farthestCar.getName());
        }
        return winners;
    }

    private PriorityQueue<Car> enqueuePriorityQueue(Player player) {
        PriorityQueue<Car> priorityQueue = new PriorityQueue<>(carDistanceDescending);
        player.getCars().forEach(priorityQueue::offer);
        return priorityQueue;
    }
}
