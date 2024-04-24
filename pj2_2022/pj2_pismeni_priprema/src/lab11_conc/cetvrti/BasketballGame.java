package lab11_conc.cetvrti;

import java.util.*;

public final class BasketballGame extends Thread {
    public Team teamA, teamB;
    public List<String> events = new ArrayList<>();
    public final Object lock = new Object();

    public Informer informer;

    public BasketballGame(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    @Override
    public void run() {
        Integer gameLength = 120 * 1000; // 2min
        Integer tickInterval = 3500, elapsed = 0;

        while (elapsed < gameLength) {
            // Get random team
            Team randomTeam = this.getRandomTeam();

            // Get random player
            Player shooter = randomTeam.getRandom();

            // Shoot
            Integer result = shooter.shoot();

            // Check for score
            if (result > 0) {
                // If scored, process
                this.logEvent(
                        String.format("[%1$s vs %2$s] Player '%3$s' scored %4$d points against %5$s!%n",
                                teamA, teamB, shooter, result, (randomTeam.equals(teamA) ? teamB : teamA))
                );
            }

            try {
                Thread.sleep(tickInterval);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            elapsed += tickInterval;
        }
    }

    private void logEvent(String event) {
        synchronized (lock) {
            this.events.add(event);
        }
    }

    private Team getRandomTeam() {
        return (new Random()).nextBoolean() ? this.teamA : this.teamB;
    }
}
