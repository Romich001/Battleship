package battleship;
// presents group of decks
public class Ship {
    Coordinate start;
    Coordinate end;
    Square[][] field;
    Fleet ship;
    private int numDecks;

    public Ship(Square[][] field, Fleet ship, Coordinate start, Coordinate end) {

        this.ship = ship;
        this.field = field;
        this.start = start;
        this.end = end;
        numDecks = ship.getDecksNum();
    }
//exp "A10 A6"
    private void reversCoordinates() {

        if((start.getY() == end.getY() && start.getX() > end.getX()) ||
                (end.getX() == start.getX() && start.getY() > end.getY())) {
            Coordinate temp = start;
            start = end;
            end = temp;
        }
    }

    public void setShip() throws Exception{
        reversCoordinates();
        Validator validator = new Validator(field, ship, start, end);
        validator.validate();
        int startX = start.getX();
        int startY = start.getY();
        int endY = end.getY();
        int evalX;
        int evalY;
        for (int i = 0; i < ship.getDecksNum(); i++) {
            if(startY == endY) {  //for horizontal ship
                evalX = i;
                evalY = 0;
            } else {              //for vertical ship
                evalY = i;
                evalX = 0;
            }

            field[startY + evalY][startX + evalX] = new Deck(this);


        }
    }
    public void sinkDeck() {
        --numDecks;
    }


    public int getNumDecks() {
        return numDecks;
    }
}
