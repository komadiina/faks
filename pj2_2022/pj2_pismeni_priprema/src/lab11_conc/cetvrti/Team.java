package lab11_conc.cetvrti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    public List<Player> players = new ArrayList<>();
    public String name;

    public Team(String name) {
        this.name = name;
    }

    public void addPlayers(List<Player> players) {
        this.players.addAll(players);
    }

    public Player getRandom() {
        // Za sut
        return players.get((new Random()).nextInt(this.players.size()));
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (o instanceof Team t)
            return this.name.equals(t.name);

        return false;
    }
}
