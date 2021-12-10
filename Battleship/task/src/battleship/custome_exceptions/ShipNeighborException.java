package battleship.custome_exceptions;

public class ShipNeighborException extends Exception{

    public ShipNeighborException () {
        super("Error! You placed it too close to another one. Try again:\n");
    }
}
