import netology.ru.Game;
import netology.ru.NotRegisteredException;
import netology.ru.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class GameTest {
    Game game = new Game();

    @Test
    public void Player1Win() {
        Player KennyS = new Player(1, "KennyS", 10);
        Player Shiro = new Player(2, "Shiro", 8);

        game.register(KennyS);
        game.register(Shiro);

        int expected = 1;
        int actual = game.round("KennyS", "Shiro");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Played2Win() {
        Player S1mple = new Player(1, "S1mple", 11);
        Player JW = new Player(2, "JW", 15);

        game.register(S1mple);
        game.register(JW);

        int expected = 2;

        int actual = game.round("S1mple", "JW");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {
        Player Kot = new Player(1, "Kot", 10);
        Player Pes = new Player(2, "Pes", 10);

        game.register(Kot);
        game.register(Pes);

        int expected = 0;
        int actual = game.round("Kot", "Pes");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Player1IsNotRegistered() {
        Player niko = new Player(1, "niko", 10);
        Player shoxx = new Player(1, "shoxx", 10);

        game.register(niko);
        game.register(shoxx);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("de1vice", "shoxx");
        });
    }
    @Test
    public void Player2IsNotRegistered() {
        Player blameF = new Player(1, "blameF", 10);
        Player zywoo = new Player(1, "zywoo", 10);

        game.register(blameF);
        game.register(zywoo);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("blameF", "karrigan");
        });
    }
}

