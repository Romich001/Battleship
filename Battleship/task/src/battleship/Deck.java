package battleship;

public class Deck extends Square{

    Ship ship;

    public Deck(Ship ship) {
        this.ship = ship;
        placeHolder = 'O';
    }

    public void hit() {
        placeHolder = 'X';
        ship.sinkDeck();
    }
    public int getShipState() {
        return ship.getNumDecks();
    }
}
