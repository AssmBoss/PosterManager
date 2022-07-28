public class PosterManager {

    private int howManyLastFilims;
    private Poster[] posterBoard = new Poster[0];

    public PosterManager() {
        this.howManyLastFilims = 10;
    }

    public PosterManager(int howManyLastFilims) {
        if (howManyLastFilims > 0) {
            this.howManyLastFilims = howManyLastFilims;
        } else {
            this.howManyLastFilims = 10;
        }
    }

    public void addPoster(Poster film) {
        Poster[] tmp = new Poster[posterBoard.length + 1];
        for (int i = 0; i < posterBoard.length; i++) {
            tmp[i] = posterBoard[i];
        }
        tmp[tmp.length - 1] = film;
        posterBoard = tmp;
    }

    public Poster[] findAll() {
        return posterBoard;
    }

    public Poster[] findLast() {
        int lastLenght;
        if (posterBoard.length < howManyLastFilims) {
            lastLenght = posterBoard.length;
        } else {
            lastLenght = howManyLastFilims;
        }
        Poster[] tmp = new Poster[lastLenght];
        for (int i = 0; i < lastLenght; i++) {
            tmp[i] = posterBoard[posterBoard.length - 1 - i];
        }
        return tmp;
    }
}
