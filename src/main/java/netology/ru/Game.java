package netology.ru;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player " + playerName1 + "is not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player " + playerName2 + "is not registered");
        }

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
