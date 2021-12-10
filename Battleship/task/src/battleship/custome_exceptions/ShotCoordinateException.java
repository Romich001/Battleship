package battleship.custome_exceptions;

public class ShotCoordinateException extends Exception{

    public ShotCoordinateException() {
        super("Error! You entered the wrong coordinates! Try again:");
    }
}
