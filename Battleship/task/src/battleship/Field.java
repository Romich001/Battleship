package battleship;

import battleship.custome_exceptions.ShotCoordinateException;

import java.util.Locale;
import java.util.Scanner;

/*
This class presents the game field matrix[10][10] .[A-J] for rows [1-10] for columns.
 */

public class Field {

    private final String name;
    private boolean fog = false;
    private final Square[][] field = new Square[10][10];
    private int shipNum = 0;
//fill the field with Square objects
    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Square();
            }
        }
    }
    public Field(String name) {
        this.name = name;
    }
//set ships in the field
    public void setShips() {
        Fleet[] fleet = Fleet.values();    //get list of ships to locate
        for (Fleet ship :
                fleet) {
            System.out.println("\nEnter the coordinates of the " + ship.getType() +

                                                                " (" + ship.getDecksNum() +" cells):\n");
            for(;;) {                       //loop for user's input. infinite till user input correct coordinates
                String[] input = getInput();
                System.out.println();
                Coordinate start = Coordinate.getCoordinate(input[0]);   //coordinate of the fist deck int the ship
                Coordinate end = Coordinate.getCoordinate(input[1]);     //coordinate of last deck in the ship
                Ship vassal = new Ship(field, ship, start, end);
                try {
                    vassal.setShip();
                    shipNum++;
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            System.out.println(this);
        }
    }

    private String[] getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toUpperCase(Locale.ROOT).split("\\s+");
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("  ");
        String firstRow = "1 2 3 4 5 6 7 8 9 10\n";
        output.append(firstRow);
        for (int i = 0; i < 10; i++) {
            output.append((char)('A' + i)).append(' ');
            for (int j = 0; j < 10; j++) {
                char ph = field[i][j].placeHolder;
                if(ph == 'O' && fog) {
                    output.append('~');
                }else {
                    output.append(ph);
                }
                output.append(' ');

            }
            output.append("\n");
        }
        output.deleteCharAt(output.lastIndexOf("\n"));
        return new String(output);
    }

    public void onFog() {
        fog = true;
    }

    public void offFog() {
        fog = false;
    }

    public void shot(){
        String msg;
        for(;;) {
            Coordinate shot = Coordinate.getCoordinate(getInput()[0]);
            try {
                Validator.checkShotCoordinate(shot);
            } catch (ShotCoordinateException e) {
                System.out.println(e.getMessage());
                continue;
            }

            Square cell = field[shot.getY()][shot.getX()];

            if(cell.placeHolder == 'O') {
                Deck deck = (Deck) field[shot.getY()][shot.getX()];
                deck.hit();
                if (deck.getShipState() == 0) {
                    shipNum--;
                    if(shipNum == 0) return;
                    msg = "\nYou sank a ship!\n";

                } else {
                    msg = "\nYou hit a ship!\n";
                }

            }
            else {
                cell.hit();
                msg = "\nYou missed!\n";
            }
            break;
        }
        System.out.println(msg);

    }

    public int getShipNum() {
        return shipNum;
    }

    public String getName() {
        return name;
    }
}
