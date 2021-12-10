package battleship;

import battleship.custome_exceptions.LocationException;
import battleship.custome_exceptions.OutDecksException;
import battleship.custome_exceptions.ShipNeighborException;
import battleship.custome_exceptions.ShotCoordinateException;

/*
This class check coordinate of ship for exceptions
 */
public class Validator {
    private final Square[][] field;
    Coordinate start;
    Coordinate end;
    private final Fleet ship;

    public Validator(Square[][] field, Fleet ship, Coordinate start, Coordinate end) {
        this.field = field;
        this.end = end;
        this.start = start;
        this.ship = ship;
    }
// method runs methods for checking 3 different exceptions
    public void validate() throws Exception{
        checkLocation();
        checkLength();
        checkShipNeighbrs();
    }
// check that the length of the ship is correct for this type of ship
    private void checkLength() throws Exception {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();
        if(startY == endY && (startX + ship.getDecksNum()) -1  != endX) {  //for horizontal ship location
            throw new OutDecksException(ship);

        }
        if(startX == endX && (startY + ship.getDecksNum()) -1 != endY){   //for vertical ship location

            throw new OutDecksException(ship);

        }
    }
// check that ship located in correct way
    private void checkLocation() throws Exception {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();
        if(startX != endX && startY != endY) {   //check if the ship locates diagonally
            throw new LocationException();
        }
        if(startX < 0 || endX > 9 || startY < 0 || endY > 9) {  //check if the ship goes out of the field
            throw new LocationException();
        }
    }

//check if the ship connects with another ship
    /*
    XXXXX
    XOOOX
    XXXXX
     */
    private void checkShipNeighbrs() throws Exception{
        int x, y;   //coordinates of top left cell upper the first ship's deck
        if(start.getY() == end.getY()) {  //for horizontal ships
            x = start.getX() - 1;
            y = start.getY() - 1;
        } else {                       //for vertical ships
            y = start.getX() - 1;
            x = start.getY() - 1;
        }

        for (int i = 0; i < 3; i++) { // check 3 rows(horizont) or 3 colones(vertical)

            for (int j = 0; j < ship.getDecksNum() + 2; j++) {  // num piecies in rows or colones

                if(x >= 0 && x < 10 && y >= 0 && y < 10) {   //skip wrong indexes
                    if(start.getY() == end.getY()) {  //for horisontal ships
                        if (field[y][x].placeHolder == 'O') throw new ShipNeighborException();
                    } else {     //for vertical ships
                        if (field[x][y].placeHolder == 'O') throw new ShipNeighborException();
                    }

                }
                x++;
            }
            y++;
            x = x - (ship.getDecksNum() + 2); //reset x

        }

    }
    public static void checkShotCoordinate(Coordinate coordinate) throws ShotCoordinateException{
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (x < 0 || x > 9 || y < 0 || y > 9) throw new ShotCoordinateException();

    }

}
