package battleship;

import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public void prepareField(Field player) {
        System.out.println(player.getName() + ", place your ships on the game field\n");
        System.out.println(player);
        player.setShips();
        passTurn();

    }

    public void move(Field shooting, Field shot) {
        shooting.offFog();
        shot.onFog();
        System.out.println(shot);
        System.out.println("----------------------");
        System.out.println(shooting);
        System.out.println("\n" + shooting.getName() + ", it's your turn:\n");
        shot.shot();
    }

    public void passTurn() {
        System.out.println("Press Enter and pass the move to another player\n");
        scanner.nextLine();
    }
    public void closeScanner() {
        scanner.close();
    }
}
