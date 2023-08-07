import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void firstPlayerWins() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 89);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        int actual = game.round("Майкл", "Эрик");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWins() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 50);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        int actual = game.round("Майкл", "Эрик");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sameStrength() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 75);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        int actual = game.round("Майкл", "Эрик");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerDoesNotExist() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 89);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джон", "Эрик")
                );
    }

    @Test
    public void secondPlayerDoesNotExist() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 89);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Майкл", "Эдвард")
        );
    }

    @Test
    public void bothPlayerDoesNotExist() {
        Game game = new Game();
        Player michel = new Player (1, "Майкл", 89);
        Player eric = new Player (2,"Эрик", 75);

        game.register(michel);
        game.register(eric);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джон", "Эдвард")
        );
    }
}