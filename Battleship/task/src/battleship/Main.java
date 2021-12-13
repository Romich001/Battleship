package battleship;

public class Main {

    public static void main(String[] args) {
        //creates two fields for game
        Field player1 = new Field("Player 1");
        Field player2 = new Field("Player 2");
        //game control
        Game game = new Game();
        //set ships
        game.prepareField(player1);
        game.prepareField(player2);

        while(true) {
             game.move(player1, player2);
             if(player1.getShipNum() == 0 || player2.getShipNum() == 0) break; //check if one of the players lost all his ships
             game.passTurn();
             //swap the referrals to field
             Field temp = player1;
             player1 = player2;
             player2 = temp;
        }
        game.closeScanner();
        System.out.println("\nYou sank the last ship. You won. Congratulations!");



    }



}
