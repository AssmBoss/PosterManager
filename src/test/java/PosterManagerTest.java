import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    Poster item1 = new Poster(1, "AAAA", "ha-ha", 1010);
    Poster item2 = new Poster(22, "BBBB", "hi-hi", 2020);
    Poster item3 = new Poster(333, "CCCC", "ho-ho", 3030);
    Poster item4 = new Poster(4444, "DDDD", "he-he", 4040);
    Poster item5 = new Poster(55555, "EEEE", "hy-hy", 5050);

    @Test
    public void shouldFillInOrder() {
        PosterManager manager = new PosterManager();
        manager.addPoster(item1);
        manager.addPoster(item2);
        manager.addPoster(item3);
        manager.addPoster(item4);
        manager.addPoster(item5);

        Poster[] expected = {item1,item2, item3, item4, item5};
        Poster[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCorrectFillPosterClass() {
        Poster testPoster = new Poster(0," ", " ", 0);

        testPoster.setId(1);
        testPoster.setFilmName("AAAA");
        testPoster.setGenre("ha-ha");
        testPoster.setReleaseYear(1010);

        int expectedId = 1;
        int actualId = testPoster.getId();

        Assertions.assertEquals (expectedId, actualId);

        String expectedFilmName = "AAAA";
        String actualFilmName = testPoster.getFilmName();
        Assertions.assertEquals (expectedFilmName, actualFilmName);

        String expectedGenre = "ha-ha";
        String actualGenre = testPoster.getGenre();
        Assertions.assertEquals (expectedGenre, actualGenre);

        int expectedYear = 1010;
        int actualYear = testPoster.getReleaseYear();
        Assertions.assertEquals (expectedYear, actualYear);

    }

    @Test
    public void shouldShowLastThree() {
        PosterManager manager = new PosterManager(3);
        manager.addPoster(item1);
        manager.addPoster(item2);
        manager.addPoster(item3);
        manager.addPoster(item4);
        manager.addPoster(item5);

        Poster[] expected = {item5,item4, item3};
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastFour() {
        PosterManager manager = new PosterManager();
        manager.addPoster(item1);
        manager.addPoster(item2);
        manager.addPoster(item3);
        manager.addPoster(item4);

        Poster[] expected = {item4, item3, item2, item1};
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void inputIncorrectHowManyLastFilms() {
        PosterManager manager = new PosterManager(-1);
        manager.addPoster(item1);
        manager.addPoster(item2);
        manager.addPoster(item3);
        manager.addPoster(item4);
        manager.addPoster(item5);
        manager.addPoster(item5);
        manager.addPoster(item4);
        manager.addPoster(item3);
        manager.addPoster(item2);
        manager.addPoster(item1);
        manager.addPoster(item1);
        manager.addPoster(item2);
        manager.addPoster(item3);
        manager.addPoster(item4);
        manager.addPoster(item5);

        Poster[] expected = {item5,item4, item3, item2,item1,item1,item2, item3, item4, item5};
        Poster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}