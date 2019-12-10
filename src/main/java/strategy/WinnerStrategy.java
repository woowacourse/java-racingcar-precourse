package strategy;

import java.util.List;

public interface WinnerStrategy<T> {

    void setParticipants(List<T> participants);

    List<T> getWinners();
}