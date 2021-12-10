package battleship.custome_exceptions;

import battleship.Fleet;

public class LocationException extends Exception{

    public LocationException() {
        super("Error! Wrong ship location! Try again:\n");
    }
}
