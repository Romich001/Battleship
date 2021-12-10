package battleship.custome_exceptions;

import battleship.Fleet;

public class OutDecksException extends Exception{

    public OutDecksException (Fleet ship) {
        super("Error! Wrong length of the " + ship.getType() + "! Try again:\n");
    }
}
