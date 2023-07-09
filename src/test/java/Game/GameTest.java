package Game;

import Game.Game;
import Game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerWin() {

        Player olya = new Player(1, "Оля", 11);
        Player kolya = new Player(2, "Коля", 10);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);
        int actual = game.round("Оля", "Коля");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void secondPlayerWin() {

        Player olya = new Player(1, "Оля", 15);
        Player kolya = new Player(2, "Коля", 11);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);
        int actual = game.round("Коля", "Оля");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void draw() {

        Player olya = new Player(1, "Оля", 11);
        Player kolya = new Player(2, "Коля", 11);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);
        int actual = game.round("Коля", "Оля");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void playerFirstIsNotRegistered() {

        Player olya = new Player(1, "Оля", 11);
        Player kolya = new Player(2, "Коля", 10);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Коля"));

    }

    @Test
    public void playerSecondIsNotRegistered() {

        Player olya = new Player(1, "Оля", 11);
        Player kolya = new Player(2, "Коля", 10);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Оля", "Петя"));

    }

    @Test
    public void playersIsNotRegistered() {

        Player olya = new Player(1, "Оля", 11);
        Player kolya = new Player(2, "Коля", 10);
        Game game = new Game();
        game.register(kolya);
        game.register(olya);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дима", "Петя"));


    }
}
