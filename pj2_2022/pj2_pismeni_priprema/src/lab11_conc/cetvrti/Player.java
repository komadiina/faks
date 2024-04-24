package lab11_conc.cetvrti;

import java.util.Random;

public final class Player extends Thread {
    public String name;
    public Integer pointsScored = 0;
    public Team team;

    Random rng = new Random();

    public Player(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    public Integer shoot() {
        // Will shoot every few seconds
        return rng.nextInt(4);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
