import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {

    Film film1 = new Film("Бладшот", "боевик");
    Film film2 = new Film("Вперед", "мультфильм");
    Film film3 = new Film("Отель Белград", "комедия");
    Film film4 = new Film("Джентельмены", "боевик");
    Film film5 = new Film("Человек-невидимка", "ужасы");
    Film film6 = new Film("Тролли. Мировой тур", "мультфильм");
    Film film7 = new Film("Номер один", "комедия");

    @Test
    public void shouldNoIncludedFilm() {
        MoviesManager manager = new MoviesManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneFilm() {
        MoviesManager manager = new MoviesManager();

        manager.addMovie("film1");

        String[] expected = {"film1"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldAddSevenFilm() {
        MoviesManager manager = new MoviesManager();

        manager.addMovie("film1");
        manager.addMovie("film2");
        manager.addMovie("film3");
        manager.addMovie("film4");
        manager.addMovie("film5");
        manager.addMovie("film6");
        manager.addMovie("film7");

        String[] expected = {"film1", "film2", "film3", "film4", "film5", "film6", "film7", };
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefault() {
        MoviesManager manager = new MoviesManager();

        manager.addMovie("film1");
        manager.addMovie("film2");
        manager.addMovie("film3");
        manager.addMovie("film4");
        manager.addMovie("film5");
        manager.addMovie("film6");
        manager.addMovie("film7");

        String[] expected = {"film7", "film6", "film5", "film4", "film3"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastTreeMovies() {
        MoviesManager manager = new MoviesManager(3);

        manager.addMovie("film1");
        manager.addMovie("film2");
        manager.addMovie("film3");
        manager.addMovie("film4");
        manager.addMovie("film5");
        manager.addMovie("film6");
        manager.addMovie("film7");

        String[] expected = {"film7", "film6", "film5"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastSevenMovies() {
        MoviesManager manager = new MoviesManager(7);

        manager.addMovie("film1");
        manager.addMovie("film2");
        manager.addMovie("film3");
        manager.addMovie("film4");
        manager.addMovie("film5");
        manager.addMovie("film6");
        manager.addMovie("film7");

        String[] expected = {"film7", "film6", "film5", "film4", "film3", "film2", "film1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastOverLimit() {
        MoviesManager manager = new MoviesManager();

        manager.addMovie("film1");
        manager.addMovie("film2");
        manager.addMovie("film3");

        String[] expected = {"film3", "film2", "film1"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}